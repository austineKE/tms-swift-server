package co.sys.procurement.tmsswiftserver.system;

import co.sys.procurement.tmsswiftserver.dto.ResponseDto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public interface TNDSystem {
    ResponseDto processLogin(String request);
    ResponseDto processRegister(String request);
    ResponseDto processSwiftProject(String request);
    ResponseDto processTermsAndCondition(String request);
    ResponseDto processPayment(String request);
    ResponseDto processTermsAndConditionsManually(String request);
    ResponseDto processNotification(String request);
    ResponseDto processSwiftSupplier(String request);
}
