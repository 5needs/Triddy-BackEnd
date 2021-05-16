package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, String>{

    Payment findByIdPayment(String idPayment);

    void deleteByIdPayment (String idPayment);
}
