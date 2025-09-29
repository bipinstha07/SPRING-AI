package com.spring.ai.controller;

import com.spring.ai.service.ChatInterface;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gpt")
public class GptTest {


    private ChatInterface chatInterface;

    public GptTest(ChatInterface chatInterface) {
        this.chatInterface = chatInterface;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(
            @RequestParam(required = false, value = "q") String q
    ){

      String result =  chatInterface.chat(q);
      return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
