package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Points;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PointsRepository extends MongoRepository<Points, String>{

    Points findByIdClient(String idClient);

}
