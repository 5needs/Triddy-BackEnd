package edu.eci.ieti.triddy.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import edu.eci.ieti.triddy.model.Message;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class ChatStompControllerTest {

    @Autowired
    ChatStompController chatStompController;

    @Test
    void sendMessageToChats(){
        Message message = new Message("user", "content", new Date(), "chatId");
        try{
            chatStompController.handlerNewMessageOfUser(message, "user");
        } catch (Exception e){
            fail();
        }
    }

    @Test
    void sendMessageToChat(){
        Message message = new Message("user", "content", new Date(), "chatId");
        try{
            chatStompController.handlerNewMessageOfChat(message, message.getChatId());
        } catch (Exception e){
            fail();
        }
    }


}