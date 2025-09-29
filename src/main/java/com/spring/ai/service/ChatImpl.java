package com.spring.ai.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ChatImpl implements ChatInterface{

    private ChatClient chatClientOpenAI;


    public ChatImpl(@Qualifier("openAIChatClient") ChatClient chatClientOpenAI) {
        this.chatClientOpenAI = chatClientOpenAI;
    }

    @Override
    public String chat(String q) {
        var resultOpenAI = chatClientOpenAI.prompt()
                .user(q)
                .system("As a expert in this field answer me")
                .call()
                .content();



        return resultOpenAI;
    }
}
