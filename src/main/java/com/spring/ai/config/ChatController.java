package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatController {

    @Bean(name="openAIChatClient")
    public ChatClient openAi(OpenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }




}
