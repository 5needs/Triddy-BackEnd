package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reclaim;

public interface ReclaimService {

    void addReclaim(Reclaim reclaim);

    Reclaim getReclaimById(String idReclaim) throws TriddyServiceException;;

    Reclaim getReclaimByIdClient(String idClient) throws TriddyServiceException;;

    Reclaim getReclaimByIdOferent(String idOferent) throws TriddyServiceException;;

    void deleteReclaimByIidReclaim(String idReclaim) throws TriddyServiceException;;
}
