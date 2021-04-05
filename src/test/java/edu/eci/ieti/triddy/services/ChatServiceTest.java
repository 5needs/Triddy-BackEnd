package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.model.Chat;
import edu.eci.ieti.triddy.model.Message;

@SpringBootTest
class ChatServiceTest {

    @Autowired
    ChatService chatService;

    @Test
    void getById(){
        Message message = new Message("user", "content", new Date(), "chatId");
        Chat chat = new Chat("user1", "user2", message);
        chat = chatService.addNewChat(chat);
        chat = chatService.getChatById(chat.getId());
        assertNotNull(chat);
    }

    @Test 
    void addMessageToChat(){
        Message message = new Message("user", "content", new Date(), "chatId");
        Chat chat = new Chat("user1", "user2", message);
        chat = chatService.addNewChat(chat);
        message = new Message("user", "content 2", new Date(), chat.getId());
        chatService.addMessageToChat(message);
        List<Message> messages = chatService.getMessagesOfChat(chat.getId());
        assertEquals(2, messages.size());
        chat = chatService.getChatById(chat.getId());
        assertEquals("content 2", chat.getLastMessage().getContent());
    }

    @Test
    void getChatsFromUser(){
        Message message = new Message("j@mail.com", "content", new Date(), "chatId");
        Chat chat = new Chat("j@mail.com", "n@mail.com", message);
        chat = chatService.addNewChat(chat);
        message = new Message("l@mail.com", "content", new Date(), "chatId");
        chat = new Chat("l@mail.com", "j@mail.com", message);
        chat = chatService.addNewChat(chat);
        List<Chat> chats = chatService.getChatsFromUser("j@mail.com");
        assertEquals(2, chats.size());
        chats = chatService.getChatsFromUser("n@mail.com");
        assertEquals(1, chats.size());
    }


    
}
