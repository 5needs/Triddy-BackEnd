package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Devolution;

import java.util.List;

public interface DevolutionService {

    void addDevolution(Devolution devolution) throws TriddyServiceException;

    List<Devolution> getDevolutionByIdProduct(String idProduct);

    List<Devolution> getDevolutionByIdClientAndStatus(String idRenter, String Status);

    List<Devolution> getDevolutionByIdUser(String idUser);

    void deleteDevolution(Devolution devolution) throws TriddyServiceException;

}
