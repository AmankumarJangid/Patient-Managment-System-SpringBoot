package com.pm.Patient_management.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chat")
public class AIChatController {

    private ChatClient chatClient;

    public AIChatController(ChatClient.Builder builder, ChatMemory chatMemory){
        this.chatClient = builder
                .defaultAdvisors(MessageChatMemoryAdvisor.builder(chatMemory).build())
                .build();
    }

    @GetMapping("")
    private ResponseEntity<String> chat(
            @RequestBody() String value,
            @RequestParam(value="chatId", defaultValue = "default") String chatId
    ){
        String output = chatClient
                .prompt()
                .user(value)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID ,chatId))
                .call()
                .content();
        return ResponseEntity.status(HttpStatus.OK).body(
                output
        );
    }
}
