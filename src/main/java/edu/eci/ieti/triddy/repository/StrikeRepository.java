package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.UserStrike;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StrikeRepository extends MongoRepository<UserStrike,String> {

    UserStrike findByIdUser(String idUser);

    List<UserStrike> findByActive(Boolean active);

    void deleteByIdUser(String idUser);

}
