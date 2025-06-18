package ru.rezzaklalala.nerzon1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rezzaklalala.nerzon1.service.MessageSendler;

@RestController
public class MainController {

    @Autowired
    private MessageSendler messageSendler;

    @PostMapping("send")
    public ResponseEntity<?> send(@RequestBody String text){
        if(text.isBlank()){
            return new ResponseEntity<>(HttpStatusCode.valueOf(400));
        }
        messageSendler.send(text);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }
}
