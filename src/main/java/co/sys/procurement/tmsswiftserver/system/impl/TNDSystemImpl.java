package co.sys.procurement.tmsswiftserver.system.impl;

import co.sys.procurement.tmsswiftserver.constants.ResponseMessage;
import co.sys.procurement.tmsswiftserver.dto.BillingDto;
import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.dto.SupplierQuotationDto;
import co.sys.procurement.tmsswiftserver.library.impl.JmsNotificationService;
import co.sys.procurement.tmsswiftserver.model.Project;
import co.sys.procurement.tmsswiftserver.model.User;
import co.sys.procurement.tmsswiftserver.service.SupplierService;
import co.sys.procurement.tmsswiftserver.service.SwiftHandlerService;
import co.sys.procurement.tmsswiftserver.service.impl.ProjectImplService;
import co.sys.procurement.tmsswiftserver.service.impl.TmsBillingServiceImpl;
import co.sys.procurement.tmsswiftserver.system.TNDSystem;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
public class TNDSystemImpl implements TNDSystem {
    private Gson gson;
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());

    @Autowired
    private ProjectImplService projectImplService;

    @Autowired
    private TmsBillingServiceImpl tmsBillingService;

    @Autowired
    private JmsNotificationService jmsNotificationService;

    @Autowired
    private SupplierService supplierService;
    @Override
    public ResponseDto processLogin(String request) {
        return null;
    }

    @Override
    public ResponseDto processRegister(String request) {
        return null;
    }

    @Override
    public ResponseDto processSwiftProject(String request) {
        try {
            gson=new Gson();
            ResponseDto responseDto=new ResponseDto();
            ResponseMessage responseMessage=new ResponseMessage();
            JsonObject projectJson= JsonParser.parseString(request).getAsJsonObject();
            JsonObject projectObject= projectJson.get("data").getAsJsonObject();
            Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {}.getType());
            Project projectVal = new ObjectMapper().convertValue(map, Project.class);
            responseDto.setCallbackId(UUID.randomUUID().toString());

            projectImplService.save(projectVal);
            responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
            return responseDto;
        }
        catch (Exception e){
            logger.error("Error occurred while saving a project {}", e);
        }
        return null;
    }

    @Override
    public ResponseDto processTermsAndCondition(String request) {
        try {
        gson=new Gson();
        ResponseDto responseDto=new ResponseDto();
        ResponseMessage responseMessage=new ResponseMessage();
        JsonObject projectJson= JsonParser.parseString(request).getAsJsonObject();
        JsonObject projectObject= projectJson.get("data").getAsJsonObject();
        Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {}.getType());
        Project projectVal = new ObjectMapper().convertValue(map, Project.class);
        responseDto.setCallbackId(UUID.randomUUID().toString());

        projectImplService.updateConditions(projectVal);
        responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
        return responseDto;
    }
        catch (Exception e){
        logger.error("Error occurred while saving a project {}", e);
    }
        return null;
    }

    @Override
    public ResponseDto processPayment(String request) {
        try {
            gson=new Gson();
            ResponseDto responseDto=new ResponseDto();
            BillingDto billingDto=new BillingDto();
            ResponseMessage responseMessage=new ResponseMessage();
            JsonObject projectJson= JsonParser.parseString(request).getAsJsonObject();
            JsonObject projectObject= projectJson.get("data").getAsJsonObject();
            Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {}.getType());
            Project projectVal = new ObjectMapper().convertValue(map, Project.class);
            responseDto.setCallbackId(UUID.randomUUID().toString());

            billingDto.setAmount("1000");
            billingDto.setPaymentType("Escrow");
            tmsBillingService.depositIntoEscrow(billingDto);
            responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
            return responseDto;
        }
        catch (Exception e){
            logger.error("Error occurred while saving a project {}", e);
        }
        return null;
    }

    @Override
    public ResponseDto processTermsAndConditionsManually(String request) {
        try {
            gson=new Gson();
            ResponseDto responseDto=new ResponseDto();
            ResponseMessage responseMessage=new ResponseMessage();
            JsonObject projectJson= JsonParser.parseString(request).getAsJsonObject();
            JsonObject projectObject= projectJson.get("data").getAsJsonObject();
            Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {}.getType());
            Project projectVal = new ObjectMapper().convertValue(map, Project.class);
            responseDto.setCallbackId(UUID.randomUUID().toString());
            projectImplService.updateConditionsManually(projectVal);
            responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
            return responseDto;
        }
        catch (Exception e){
            logger.info("Error occurred while saving project record {}", e);
        }
        return null;
    }

    @Override
    public ResponseDto processNotification(String request) {
        try {
            gson = new Gson();
            ResponseDto responseDto = new ResponseDto();
            User user = new User();
            user.setEmail("austinewamalwa@gmail.com");
            ResponseMessage responseMessage = new ResponseMessage();
            JsonObject projectJson = JsonParser.parseString(request).getAsJsonObject();
            JsonObject projectObject = projectJson.get("data").getAsJsonObject();
            Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {
            }.getType());
            Project projectVal = new ObjectMapper().convertValue(map, Project.class);
            responseDto.setCallbackId(UUID.randomUUID().toString());
            jmsNotificationService.sendNotification(user.getEmail(), "Value being sent");
            responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
            return responseDto;
        }
        catch (Exception e){
            logger.info("Error processing notification {}", e);
        }
        return null;
    }

    @Override
    public ResponseDto processSwiftSupplier(String request) {
        try {
        gson = new Gson();
        ResponseDto responseDto = new ResponseDto();
        ResponseMessage responseMessage = new ResponseMessage();
        JsonObject projectJson = JsonParser.parseString(request).getAsJsonObject();
        JsonObject projectObject = projectJson.get("data").getAsJsonObject();
        Map<String, Object> map = gson.fromJson(projectObject, new TypeToken<Map<String, Object>>() {
        }.getType());
        SupplierQuotationDto supplierQuotationDto = new ObjectMapper().convertValue(map, SupplierQuotationDto.class);
        supplierService.saveQuotation(supplierQuotationDto);
        responseDto.setCallbackId(UUID.randomUUID().toString());
        responseDto.setMessage(responseMessage.getResponseMessage().getProperty("project.saveError"));
        return responseDto;
    }
        catch (Exception e){
        logger.info("Error processing notification {}", e);
    }
        return null;
    }
}
