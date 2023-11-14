package co.sys.procurement.tmsswiftserver.system;

import co.sys.procurement.tmsswiftserver.dto.ResponseDto;

public interface TNDSystem {
    ResponseDto processLogin(String request);
    ResponseDto processRegister(String request);
    ResponseDto processSwiftProject(String request);
    ResponseDto processTermsAndCondition(String request);
    ResponseDto processPayment(String request);
}
