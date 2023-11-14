package co.sys.procurement.tmsswiftserver.library;

import co.sys.procurement.tmsswiftserver.conf.HttpConfiguration;
import co.sys.procurement.tmsswiftserver.dto.STKPushRequest;
import co.sys.procurement.tmsswiftserver.dto.STKResponse;
import co.sys.procurement.tmsswiftserver.exception.MpesaException;

public interface MpesaCoreTemplate {

    /**
     * Call MPesa API for STK Push
     *
     * @param stkPushRequest
     * @return
     */
    STKResponse stkPushRequest(STKPushRequest stkPushRequest, String accessToken, String url, HttpConfiguration httpConfiguration) throws MpesaException;

}
