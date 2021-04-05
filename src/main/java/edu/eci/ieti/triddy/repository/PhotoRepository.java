package edu.eci.ieti.triddy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.triddy.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> { 
    
}
