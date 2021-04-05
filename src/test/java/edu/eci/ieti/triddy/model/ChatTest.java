package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ChatTest {

    @Test
    void createChat(){
        Chat chat = new Chat();
        assertNotNull(chat);
        Message message = new Message();
        chat = new Chat("user1", "user2", message);
        assertNotNull(chat);
    }

    @Test
    void setChat(){
        Chat chat = new Chat();
        chat.setId("id");
        assertEquals("id", chat.getId());
        chat.setUser1("user1");
        assertEquals("user1", chat.getUser1());
        chat.setUser2("user2");
        assertEquals("user2", chat.getUser2());
        Message message = new Message();
        chat.setLastMessage(message);
        assertNotNull(chat.getLastMessage());
    }
    
}
