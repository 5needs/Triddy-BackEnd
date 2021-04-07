package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ChatTest {

    @Test
    void createChat(){
        Chat chat = new Chat();
        assertNotNull(chat);
        Message message = new Message();
        chat = new Chat("user1", "user2", message);
        assertNotNull(chat);
        String s = String.format("Chat[ id= '%s', user1= '%s', user2= '%s', lastMessage= '%s']"
        ,chat.getId(),chat.getUser1(),chat.getUser2(), chat.getLastMessage());
        assertEquals(s, chat.toString());
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
