package co.sys.procurement.tmsswiftserver.library.impl;

import co.sys.procurement.tmsswiftserver.conf.HttpConfiguration;
import co.sys.procurement.tmsswiftserver.exception.MpesaException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class MpesaHelpers {
    private Logger LOGGER= LoggerFactory.getLogger(this.getClass().getName());
    /**
     * Generic function for sending POST HTTP requests
     *
     * @param url
     * @param accessToken
     * @param body
     * @param responseClass
     * @return
     */
    public Object httpPostRequest(String url, String accessToken, Object body, Class responseClass,
                                  HttpConfiguration httpConfiguration) throws MpesaException {
        Integer connectionTimeout = (httpConfiguration.getConnectionTimeout() == null) ? 10 :
                httpConfiguration.getConnectionTimeout();
        Integer readTimeout = (httpConfiguration.getReadTimeout() == null) ? 10 :
                httpConfiguration.getReadTimeout();
        TimeUnit timeUnit = (httpConfiguration.getTimeUnit() == null) ? TimeUnit.SECONDS :
                httpConfiguration.getTimeUnit();

        ObjectMapper mapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MpesaException(e.getMessage());
        }

        RequestBody requestBody = RequestBody
                .create(MediaType.parse("application/json"), jsonString);

        OkHttpClient client = new OkHttpClient();
                client.setConnectTimeout(connectionTimeout, timeUnit);
                client.setReadTimeout(readTimeout, timeUnit);
                client.setWriteTimeout(connectionTimeout, timeUnit);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .header("authorization", "Bearer " + accessToken)
                .header("cache-control", "no-cache")
                .header("content-type", "application/json")
                .header("accept", "application/json")
                .build();

        LOGGER.info("MPESA Request : " + jsonString);
        String response = "";
        try {
            Response resp = client.newCall(request).execute();
            response = resp.body().string();
            LOGGER.info("MPESA Response : " + response);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MpesaException(e.getMessage());
        }

        try {
            Object callbackResponse = new ObjectMapper().readValue(response, responseClass);
            return callbackResponse;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new MpesaException(response);

        }
    }
}
