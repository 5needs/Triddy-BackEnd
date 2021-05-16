package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>{

    public User findByEmail(String email);

    public void deleteByEmail(String string);
    
}
