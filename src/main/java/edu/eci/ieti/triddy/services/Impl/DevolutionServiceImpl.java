package edu.eci.ieti.triddy.services.Impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Devolution;
import edu.eci.ieti.triddy.repository.DevolutionRepository;
import edu.eci.ieti.triddy.services.DevolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("devolutionService")
public class DevolutionServiceImpl implements DevolutionService {

    @Autowired
    DevolutionRepository devolutionRepository;

    @Override
    public void addDevolution(Devolution devolution)  throws TriddyServiceException{
        Devolution devolution1 = devolutionRepository.findByIdDevolution(devolution.getIdDevolution());
        if (devolution1 != null){
            throw new TriddyServiceException("Devolution already Exists");
        }
        devolutionRepository.save(devolution);
    }

    @Override
    public List<Devolution> getDevolutionByIdProduct(String idProduct) {
        List<Devolution> devolutions = devolutionRepository.findByIdProduct(idProduct);
        return devolutions;
    }

    @Override
    public List<Devolution> getDevolutionByIdClientAndStatus(String idRenter, String status) {
        List<Devolution> devolutions = devolutionRepository.findByIdClientAndStateDelivery(idRenter,status);
        return devolutions;
    }

    @Override
    public List<Devolution> getDevolutionByIdUser(String idUser) {
        List<Devolution> devolutions = devolutionRepository.findByIdUser(idUser);
        return devolutions;
    }

    @Override
    public void deleteDevolution(Devolution devolution) throws TriddyServiceException{
        Devolution devolution1 = devolutionRepository.findByIdDevolution(devolution.getIdDevolution());
        if (devolution1 == null){
            throw new TriddyServiceException("Devolution Not Found");
        }
        devolutionRepository.deleteByIdDevolution(devolution.getIdDevolution());
    }
}
