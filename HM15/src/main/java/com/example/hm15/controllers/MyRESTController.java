package com.example.hm15.controllers;

import com.example.hm15.Conversation;
import com.example.hm15.Message;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@RestController
public class MyRESTController {

    @PostMapping("/messages")
    public ResponseEntity<Message> sendMessage(@RequestBody Message message, @RequestHeader(value = "authentication", required = false) String authentication) throws IOException {
        File file = new File("src/main/resources/static/input2.json");
        ObjectMapper objectMapper = new ObjectMapper();
        Conversation conversation = objectMapper.readValue(new File("src/main/resources/static/input2.json"), Conversation.class);
        conversation.getMessages().add(message);
        objectMapper.writeValue(file, conversation);
        ResponseEntity response;

        if (authentication == null) {
            response = new ResponseEntity<Message>(message, HttpStatusCode.valueOf(401));
        }else if(authentication.equalsIgnoreCase("devmind-api-key")) {
            response = new ResponseEntity<Message>(message, HttpStatusCode.valueOf(201));
        } else {
            response = new ResponseEntity<Message>(message, HttpStatusCode.valueOf(401));
        }
        return response;

    }
}
