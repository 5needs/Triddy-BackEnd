package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MessageTest {

    @Test
    void createMessage(){
        Message message = new Message();
        assertNotNull(message);
        message = new Message("user", "content", new Date(), "chatId");
        assertNotNull(message);
    }

    @Test
    void setMessage(){
        Message message = new Message();
        message.setChatId("chatId");
        assertEquals("chatId", message.getChatId());
        message.setContent("content");
        assertEquals("content", message.getContent());
        message.setUser("user");
        assertEquals("user", message.getUser());
        message.setDate(new Date());
        assertEquals(new Date(), message.getDate());
    }
    
}
