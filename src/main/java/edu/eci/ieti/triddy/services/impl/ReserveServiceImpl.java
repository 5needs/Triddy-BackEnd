package edu.eci.ieti.triddy.services.Impl;

import edu.eci.ieti.triddy.model.Reserve;
import edu.eci.ieti.triddy.repository.ReserveRepository;
import edu.eci.ieti.triddy.services.ReserveService;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    ReserveRepository reserveRepository;

    @Override
    public void deleteReserveByIdReserve(String idReserve) throws TriddyServiceException {
        Reserve reserve = getReserveByIdReserve(idReserve);
        reserveRepository.deleteByIdReserve(reserve.getIdReserve());
    }

    @Override
    public Reserve getReserveByIdReserve(String idReserve) throws TriddyServiceException {
        Reserve reserve = reserveRepository.findByIdReserve(idReserve);
        if (reserve != null){
            return reserve;
        }else{
            throw new TriddyServiceException("Reserve with Id: "+idReserve+" is not registered");
        }
    }

    @Override
    public List<Reserve> getReserveByIdClient(String idClient) throws TriddyServiceException {
        List<Reserve> reserve = reserveRepository.findByIdClient(idClient);
        System.out.println(reserve);
        if (!reserve.isEmpty()){
            return reserve;
        }else{
            throw new TriddyServiceException("Reserves with Id Client: "+idClient+" is not registered");
        }
    }

    @Override
    public void addReserve(Reserve reserve) {
        reserveRepository.save(reserve);
    }

}
