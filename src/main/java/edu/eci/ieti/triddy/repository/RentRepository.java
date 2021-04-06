package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Rent;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentRepository extends MongoRepository<Rent,String> {
}
