package com.spring.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.vertexai.gemini.VertexAiGeminiChatModel;
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

    private ChatClient chatClientOpenAI;
    private ChatClient chatClientGeminiAI;


    public GptTest(@Qualifier("openAIChatClient") ChatClient chatClientGeminiAI, @Qualifier("geminiChatClient") ChatClient chatClientOpenAI) {
        this.chatClientGeminiAI = chatClientGeminiAI;
        this.chatClientOpenAI = chatClientOpenAI;
    }

    @GetMapping("/test")
    public ResponseEntity<String> test(
            @RequestParam(required = false, value = "q") String q
    ){

        var resultOpenAI = chatClientOpenAI.prompt(q).call().content();
        var resultGeminiAI = chatClientGeminiAI.prompt(q).call().content();
        String result = "Open AI Output: "+resultOpenAI+ "/n Gemini AI Output: "+resultGeminiAI;
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
