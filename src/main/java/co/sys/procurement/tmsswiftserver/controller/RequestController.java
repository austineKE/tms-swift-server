package co.sys.procurement.tmsswiftserver.controller;

import co.sys.procurement.tmsswiftserver.dto.ResponseDto;
import co.sys.procurement.tmsswiftserver.service.SwiftHandlerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.ResponseCache;

@Controller
@RequestMapping
public class RequestController {
    private static final Gson gson = new Gson();

    @Autowired
    private SwiftHandlerService swiftHandlerService;

    @PostMapping(value = "/ts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> serveCliRequest(@RequestBody String request) {
        return new ResponseEntity<>(swiftHandlerService.processCliRequest(request), HttpStatus.OK);
    }

    @PostMapping(value = "/tq", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> serveSupRequest(@RequestBody String request) {
        return new ResponseEntity<>(swiftHandlerService.processSupRequest(request), HttpStatus.OK);
    }


}
