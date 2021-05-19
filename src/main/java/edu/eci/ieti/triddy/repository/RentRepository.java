package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Rent;
import edu.eci.ieti.triddy.model.Reserve;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RentRepository extends MongoRepository<Rent,String> {
    List<Rent> findByUserEmail(String userEmail);
}