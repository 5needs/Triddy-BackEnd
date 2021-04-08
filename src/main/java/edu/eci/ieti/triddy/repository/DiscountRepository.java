package edu.eci.ieti.triddy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.eci.ieti.triddy.model.Discount;

public interface DiscountRepository extends MongoRepository<Discount, String> {

    List<Discount> findByEndAfterAndStartBefore(Date end, Date start);

    List<Discount> findByProductAndEndAfterAndStartBefore(String product, Date end, Date start);
    
    List<Discount> findByTypeAndEndAfterAndStartBefore(String type, Date end, Date start);

    List<Discount> findByProduct(String product);
    
}
