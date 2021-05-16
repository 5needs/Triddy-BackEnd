package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Object> findAllById(String id);
}