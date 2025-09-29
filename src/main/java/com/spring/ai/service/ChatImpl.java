package com.spring.ai.service;

import com.spring.ai.dto.Response;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatImpl implements ChatInterface{

    private ChatClient chatClientOpenAI;


    public ChatImpl(@Qualifier("openAIChatClient") ChatClient chatClientOpenAI) {
        this.chatClientOpenAI = chatClientOpenAI;
    }

    @Override
    public String chat(String q) {

//        One Method
//        var resultOpenAI = chatClientOpenAI.prompt()
//                .user(q)
//                .system("As a expert in this field answer me")
//                .call()
//                .content();
//
//      Second Method
//        var resultOpenAI2 = chatClientOpenAI.prompt(q).call().chatResponse().getResult().getOutput().getText();
// 
//      
//      Third Method
//        Response resultOpenAI3 = chatClientOpenAI.prompt(q).call().entity(Response.class);
//        
//        Fourth Method
        List<Response> resultOpenAI4 = chatClientOpenAI.prompt(q).call().entity(new ParameterizedTypeReference<List<Response>>() {
        });



        resultOpenAI4.forEach(resultOpenAI3->{
            System.out.println(resultOpenAI3.getId());
            System.out.println(resultOpenAI3.getContent());
            System.out.println(resultOpenAI3.getNextQuestion());
        });


        return "hi";
    }
}
