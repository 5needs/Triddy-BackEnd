package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product,String> {

     Product findProductById(String id);

     List<Product> findByUserId(String idUser);
}
