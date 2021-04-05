package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.Chat;
import edu.eci.ieti.triddy.model.Message;

public interface ChatService{

    Chat getChatById(String id);
    List<Message> getMessagesOfChat(String chatId);
    List<Chat> getChatsFromUser(String user);
    Chat addNewChat(Chat chat);
    Message addMessageToChat (Message message);
}