package co.sys.procurement.tmsswiftserver.service;

import co.sys.procurement.tmsswiftserver.dto.BillingDto;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;

import java.io.IOException;

public interface TmsBillingService {
    ResponseDto depositIntoEscrow(BillingDto depositRequest) throws IOException;
}
