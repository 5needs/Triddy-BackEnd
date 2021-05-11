package edu.eci.ieti.triddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/{chatId}")
    public ResponseEntity<Chat> getChatById(@PathVariable String chatId){
        Chat chat = chatService.getChatById(chatId);
        if (chat != null){
            return new ResponseEntity<>(chat, HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{user}")
    public ResponseEntity<List<Chat>> getChatsFromUser(@PathVariable String user){
        List<Chat> chats = chatService.getChatsFromUser(user);
        return new ResponseEntity<>(chats, HttpStatus.ACCEPTED);
    }

    @GetMapping("/messages/{chatId}")
    public ResponseEntity<List<Message>> getMessagesOfChat(@PathVariable String chatId){
        List<Message> messages = chatService.getMessagesOfChat(chatId);
        return new ResponseEntity<>(messages, HttpStatus.ACCEPTED);
    }


    @PostMapping
    public ResponseEntity<Chat> addChat(@RequestBody Chat chat){
        try{
            Chat newChat = chatService.addNewChat(chat);
            return new ResponseEntity<>(newChat, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PostMapping("/messages")
    public ResponseEntity<Message> addMessageToChat(@RequestBody Message message){
        try{
            Message newMessage = chatService.addMessageToChat(message);
            return new ResponseEntity<>(newMessage, HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
}