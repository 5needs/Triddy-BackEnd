package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Devolution;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DevolutionRepository extends MongoRepository<Devolution, String> {

    Devolution findByIdDevolution(String idDevolution);

    List<Devolution> findByIdProduct(String product);

    List<Devolution> findByIdUser(String idUser);

    List<Devolution> findByIdClientAndStateDelivery(String idClient,String status);

    void deleteByIdDevolution(String idDevolution);
}
