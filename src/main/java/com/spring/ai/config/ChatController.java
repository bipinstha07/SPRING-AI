package com.spring.ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatController {

    @Bean(name="openAIChatClient")
    public ChatClient openAi(OpenAiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }


    @Bean(name="geminiChatClient")
    public ChatClient geminiAI(VertexAiGeminiChatModel chatModel){
        return ChatClient.builder(chatModel).build();
    }

}
