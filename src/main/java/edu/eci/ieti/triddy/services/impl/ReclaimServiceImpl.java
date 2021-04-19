package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.model.Reclaim;
import edu.eci.ieti.triddy.repository.ReclaimRepository;
import edu.eci.ieti.triddy.services.ReclaimService;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReclaimServiceImpl implements ReclaimService {

    @Autowired
    ReclaimRepository reclaimRepository;

    @Override
    public void addReclaim(Reclaim reclaim) {
        reclaimRepository.save(reclaim);
    }

    @Override
    public Reclaim getReclaimById(String idReclaim) throws TriddyServiceException {
        Reclaim reclaim = reclaimRepository.findByIdReclaim(idReclaim);
        if (reclaim!=null){
            return reclaim;
        }else{
            throw new TriddyServiceException("Reclaim with Id : "+idReclaim+" is not registered");
        }
    }

    @Override
    public Reclaim getReclaimByIdClient(String idClient) throws TriddyServiceException {
        Reclaim reclaim = reclaimRepository.findByIdClient(idClient);
        if (reclaim!=null){
            return reclaim;
        }else{
            throw new TriddyServiceException("Reclaim with idClient : "+idClient+" is not registered");
        }
    }

    @Override
    public Reclaim getReclaimByIdOferent(String idOferent) throws TriddyServiceException {
        Reclaim reclaim = reclaimRepository.findByIdOferent(idOferent);
        if (reclaim!=null){
            return reclaim;
        }else{
            throw new TriddyServiceException("Reclaim with idOferent : "+idOferent+" is not registered");
        }
    }

    @Override
    public void deleteReclaimByIidReclaim(String idReclaim) throws TriddyServiceException {
        Reclaim reclaim = getReclaimById(idReclaim);
        reclaimRepository.deleteByIdReclaim(reclaim.getIdReclaim());
    }
}
