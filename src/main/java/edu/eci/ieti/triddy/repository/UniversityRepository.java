package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.University;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UniversityRepository extends MongoRepository<University, String>{

    University findByIdUniversity(String idUniversity);

    void deleteByIdUniversity (String idPayment);

}
