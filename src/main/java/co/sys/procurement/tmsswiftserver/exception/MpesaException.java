package co.sys.procurement.tmsswiftserver.exception;

import co.sys.procurement.tmsswiftserver.dto.MpesaErrorResponse;

public class MpesaException extends Exception{
    public MpesaException(String errorMessage) {
        super(errorMessage);
    }

    public MpesaException(String errorMessage, Exception ex) {
        super(errorMessage);
    }

    public MpesaException(String errorMessage, MpesaErrorResponse ex) {
        super(errorMessage);
    }
}
