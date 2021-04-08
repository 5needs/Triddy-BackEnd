package edu.eci.ieti.triddy.repository;

import edu.eci.ieti.triddy.model.Reclaim;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReclaimRepository extends MongoRepository<Reclaim, String>{

    Reclaim findByIdClient(String idClient);

    void deleteByIdReclaim(String idReclaim);

    Reclaim findByIdReclaim(String idReclaim);

    Reclaim findByIdOferent(String idOferent);
}