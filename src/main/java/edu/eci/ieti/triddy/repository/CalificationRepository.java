package edu.eci.ieti.triddy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.triddy.model.Calification;

public interface CalificationRepository extends MongoRepository<Calification, String>  {

    List<Calification> findByProduct(String product);

    List<Calification> findByUser(String user);

    List<Calification> findByQualifier(String qualifier);

}
