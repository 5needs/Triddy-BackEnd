package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Reserve;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ReserveRepository extends MongoRepository<Reserve, String>{

    Reserve findByIdReserve(String idReserve);

    void deleteByIdReserve (String idReserve);

    List<Reserve> findByIdClient(String idClient);
}
