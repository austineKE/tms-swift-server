package co.sys.procurement.tmsswiftserver.service;

import co.sys.procurement.tmsswiftserver.constants.RequestType;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.service.impl.ProjectImplService;
import co.sys.procurement.tmsswiftserver.system.impl.TNDSystemImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiftHandlerService {
    @Autowired
    private ProjectImplService projectImplService;
    @Autowired
    private TNDSystemImpl tndSystem;

    public ResponseDto processTsRequest(String request) {
        //first check if the session is valid

        //validate the request and type
        //call appropriate service to process the request
        ResponseDto responseDto=null;
        JsonObject jsonAsRequest= JsonParser.parseString(request).getAsJsonObject();
        String requestType=jsonAsRequest.get("requestType").getAsString();
        switch (requestType){
            case RequestType.QUOTATION:
                responseDto=tndSystem.processSwiftProject(request);
                break;
            case RequestType.TERMSANDCONDITIONS:
                responseDto=tndSystem.processTermsAndCondition(request);
                break;

            case RequestType.DEPOSITTOESCROW:
                responseDto=tndSystem.processPayment(request);
                break;
        }
        return responseDto;
    }
}
