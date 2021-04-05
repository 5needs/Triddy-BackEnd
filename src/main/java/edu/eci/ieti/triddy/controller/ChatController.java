package edu.eci.ieti.triddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.Chat;
import edu.eci.ieti.triddy.model.Message;
import edu.eci.ieti.triddy.services.ChatService;


@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/{chatId}")
    public ResponseEntity<?> getChatById(@PathVariable String chatId){
        Chat chat = chatService.getChatById(chatId);
        if (chat != null){
            return new ResponseEntity<>(chat, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<?> getChatsFromUser(@PathVariable String user){
        List<Chat> chats = chatService.getChatsFromUser(user);
        if (chats != null){
            return new ResponseEntity<>(chats, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/messages/{chatId}")
    public ResponseEntity<?> getMessagesOfChat(@PathVariable String chatId){
        List<Message> messages = chatService.getMessagesOfChat(chatId);
        if (messages != null){
            return new ResponseEntity<>(messages, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<?> addChat(@RequestBody Chat chat){
        Chat newChat = chatService.addNewChat(chat);
        if (newChat != null){
            return new ResponseEntity<>(newChat, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<?> addMessageToChat(@RequestBody Message message){
        Message newMessage = chatService.addMessageToChat(message);
        if (newMessage != null){
            return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}