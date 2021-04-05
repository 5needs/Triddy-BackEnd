package edu.eci.ieti.triddy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.triddy.model.Message;

public interface MessageRepository extends MongoRepository<Message, String> {

    public List<Message> findByChatId(String chatId);
    
}
