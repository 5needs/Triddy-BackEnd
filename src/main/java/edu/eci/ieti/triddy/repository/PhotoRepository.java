package edu.eci.ieti.triddy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import edu.eci.ieti.triddy.model.Photo;

public interface PhotoRepository extends MongoRepository<Photo, String> {
    @Query(value="{}", fields="{ image : 0}") 
    List<Photo> findExcludeImage();
    @Query(value="{_id : ?0 }", fields="{ title : 1, _id : 0}")
    String findTitleById(String id);
}
