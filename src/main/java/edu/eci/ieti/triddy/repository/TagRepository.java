package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.ProductTag;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TagRepository extends MongoRepository<ProductTag,String>{

     ProductTag findByKeyword(String keyword);

     void deleteByKeyword(String keyword);
}
