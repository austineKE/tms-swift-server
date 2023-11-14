package co.sys.procurement.tmsswiftserver.library.impl;

import co.sys.procurement.tmsswiftserver.conf.HttpConfiguration;
import co.sys.procurement.tmsswiftserver.dto.STKPushRequest;
import co.sys.procurement.tmsswiftserver.dto.STKResponse;
import co.sys.procurement.tmsswiftserver.exception.MpesaException;
import co.sys.procurement.tmsswiftserver.library.MpesaCoreTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MpesaCoreService implements MpesaCoreTemplate {
    @Autowired
    private MpesaHelpers mpesaHelpers;

    @Override
    public STKResponse stkPushRequest(STKPushRequest stkPushRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException {
        STKResponse response = (STKResponse) mpesaHelpers.httpPostRequest(url, accessToken, stkPushRequest, STKResponse.class, httpConfiguration);
        return response;
    }
}
