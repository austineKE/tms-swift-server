package co.sys.procurement.tmsswiftserver.service;

import co.sys.procurement.tmsswiftserver.constants.RequestType;
import co.sys.procurement.tmsswiftserver.dto.Email;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.library.impl.JmsNotificationService;
import co.sys.procurement.tmsswiftserver.service.impl.ProjectImplService;
import co.sys.procurement.tmsswiftserver.system.impl.TNDSystemImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiftHandlerService {
    @Autowired
    private TNDSystemImpl tndSystem;

    public ResponseDto processCliRequest(String request) {
        //first check if the session is valid

        //validate the request and type
        //call appropriate service to process the request
        ResponseDto responseDto=null;
        JsonObject jsonAsRequest= JsonParser.parseString(request).getAsJsonObject();
        String requestType=jsonAsRequest.get("requestType").getAsString();
        switch (requestType){
            case RequestType.PROJECT:
                responseDto=tndSystem.processSwiftProject(request);
                break;
            case RequestType.TERMSANDCONDITIONS:
                responseDto=tndSystem.processTermsAndCondition(request);
                break;

            case RequestType.DEPOSITTOESCROW:
                responseDto=tndSystem.processPayment(request);
                break;
            case RequestType.MANUALLYAGREEDTERMS:
                responseDto=tndSystem.processTermsAndConditionsManually(request);
                break;
            case RequestType.NOTIFY:
                responseDto=tndSystem.processNotification(request);
                break;
        }
        return responseDto;
    }

    public ResponseDto processSupRequest(String request) {
        //first check if the session is valid

        //validate the request and type
        //call appropriate service to process the request
        ResponseDto responseDto=null;
        JsonObject jsonAsRequest= JsonParser.parseString(request).getAsJsonObject();
        String requestType=jsonAsRequest.get("requestType").getAsString();
        switch (requestType){
            case RequestType.QUOTATION:
                responseDto=tndSystem.processSwiftSupplier(request);
                break;
            case RequestType.TERMSANDCONDITIONS:
                responseDto=tndSystem.processTermsAndCondition(request);
                break;
    }
        return responseDto;
    }
}
