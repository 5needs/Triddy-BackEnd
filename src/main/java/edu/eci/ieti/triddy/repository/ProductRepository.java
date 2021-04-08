package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    
}
