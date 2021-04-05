package edu.eci.ieti.triddy.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.Chat;
import edu.eci.ieti.triddy.model.Message;
import edu.eci.ieti.triddy.repository.ChatRepository;
import edu.eci.ieti.triddy.repository.MessageRepository;
import edu.eci.ieti.triddy.services.ChatService;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    MessageRepository messageRepository;

    public Chat getChatById(String id){
        Chat chat = null;
        Optional<Chat> chatOp = chatRepository.findById(id); 
        if (chatOp.isPresent()){
            chat = chatOp.get();
        }
        return chat;
    }

    public List<Message> getMessagesOfChat(String chatId){
        return messageRepository.findByChatId(chatId);
    }

    public List<Chat> getChatsFromUser(String user){
        return chatRepository.findByUser1OrUser2(user, user);
    }

    public Chat addNewChat(Chat chat){
        Chat newChat = chatRepository.save(chat);
        newChat.getLastMessage().setChatId(newChat.getId());
        newChat = chatRepository.save(newChat);
        messageRepository.insert(newChat.getLastMessage());
        return newChat;
    }

    public Message addMessageToChat (Message message){
        Chat chat = getChatById(message.getChatId());
        chat.setLastMessage(message);
        chatRepository.save(chat);
        Message newMessage = messageRepository.save(message);
        return newMessage;
    }
}
