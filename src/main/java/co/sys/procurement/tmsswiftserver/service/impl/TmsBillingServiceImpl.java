package co.sys.procurement.tmsswiftserver.service.impl;

import co.sys.procurement.tmsswiftserver.dto.BillingDto;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.service.TmsBillingService;
import com.google.gson.Gson;
import com.squareup.okhttp.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class TmsBillingServiceImpl implements TmsBillingService {
    private Logger logger=LoggerFactory.getLogger(this.getClass().getName());

    @Override
    public ResponseDto depositIntoEscrow(BillingDto depositRequest){
        //payment integration needed
        //mpesa integration
        OkHttpClient client = new OkHttpClient();
        String rq=new Gson().toJson(depositRequest);
//        JsonObject obj= JsonParser.parseString(rq).getAsJsonObject();
        MediaType JSON = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(JSON, rq);
        Request request = new Request.Builder()
                .url("https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials")
                .get().addHeader("Authorization", "Basic SWZPREdqdkdYM0FjWkFTcTdSa1RWZ2FTSklNY001RGQ6WUp4ZVcxMTZaV0dGNFIzaA==")
                .post(requestBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            logger.info("Response from m-pesa is {}", body.string());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
