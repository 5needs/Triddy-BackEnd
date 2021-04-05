package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.Chat;
import edu.eci.ieti.triddy.model.Message;

@SpringBootTest
public class ChatControllerTest {

    @Autowired
    ChatController chatController;

    @Test
    void getById(){
        Message message = new Message("user", "content", new Date(), "chatId");
        Chat chat = new Chat("user1", "user2", message);
        ResponseEntity<?> resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        resp = chatController.getChatById(chat.getId());
        chat = (Chat) resp.getBody();
        assertNotNull(chat);
    }

    @Test 
    void addMessageToChat(){
        Message message = new Message("user", "content", new Date(), "chatId");
        Chat chat = new Chat("user1", "user2", message);
        ResponseEntity<?> resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        message = new Message("user", "content 2", new Date(), chat.getId());
        chatController.addMessageToChat(message);
        resp = chatController.getMessagesOfChat(chat.getId());
        List<?> messages = (List<?>) resp.getBody();
        assertEquals(2, messages.size());
        resp = chatController.getChatById(chat.getId());
        chat = (Chat) resp.getBody();
        assertEquals(chat.getLastMessage().getContent(), "content 2");
    }

    @Test
    void getChatsFromUser(){
        Message message = new Message("j@mail.com", "content", new Date(), "chatId");
        Chat chat = new Chat("j@mail.com", "n@mail.com", message);
        ResponseEntity<?> resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        message = new Message("l@mail.com", "content", new Date(), "chatId");
        chat = new Chat("l@mail.com", "j@mail.com", message);
        resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        resp = chatController.getChatsFromUser("j@mail.com");
        List<?> chats = (List<?>) resp.getBody();
        assertEquals(2, chats.size());
        resp = chatController.getChatsFromUser("n@mail.com");
        chats = (List<?>) resp.getBody();
        assertEquals(1, chats.size());
    }


    
}
