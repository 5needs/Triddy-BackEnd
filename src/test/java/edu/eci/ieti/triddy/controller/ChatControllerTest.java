package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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
class ChatControllerTest {

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
        assertEquals("content 2", chat.getLastMessage().getContent());
    }

    @Test
    void getChatsFromUser(){
        Message message = new Message("j2@mail.com", "content", new Date(), "chatId");
        Chat chat = new Chat("j2@mail.com", "n2@mail.com", message);
        ResponseEntity<?> resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        message = new Message("l2@mail.com", "content", new Date(), "chatId");
        chat = new Chat("l2@mail.com", "j2@mail.com", message);
        resp= chatController.addChat(chat);
        chat = (Chat) resp.getBody();
        resp = chatController.getChatsFromUser("j2@mail.com");
        List<?> chats = (List<?>) resp.getBody();
        assertEquals(2, chats.size());
        resp = chatController.getChatsFromUser("n2@mail.com");
        chats = (List<?>) resp.getBody();
        assertEquals(1, chats.size());
    }

    @Test
    void getNotExistingChat(){
        ResponseEntity<?> resp= chatController.getChatById("no id");
        assertFalse(resp.hasBody()); 
    }

    @Test
    void addNullChat(){
        ResponseEntity<?> resp= chatController.addChat(null);
        assertFalse(resp.hasBody()); 
    }

    @Test
    void addNullMessage(){
        ResponseEntity<?> resp= chatController.addMessageToChat(null);
        assertFalse(resp.hasBody()); 
    }
    
}