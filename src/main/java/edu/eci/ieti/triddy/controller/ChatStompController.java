package edu.eci.ieti.triddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.eci.ieti.triddy.model.Message;

@Controller
@CrossOrigin("*")
public class ChatStompController {

    @Autowired
    SimpMessagingTemplate msgt;

    @MessageMapping("/chats.{user}")
    public void handlerNewMessageOfUser(Message message, @DestinationVariable String user){
        msgt.convertAndSend("stompClient/chats." + user, message);
    }

    @MessageMapping("/messages.{chat}")
    public void handlerNewMessageOfChat(Message message, @DestinationVariable String chat){
        msgt.convertAndSend("stompClient/messages." + chat, message);
    }
}
