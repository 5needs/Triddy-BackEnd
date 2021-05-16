package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reserve;

import java.util.List;

public interface ReserveService {

    void deleteReserveByIdReserve(String idReserve) throws TriddyServiceException;

    Reserve getReserveByIdReserve(String idReserve) throws TriddyServiceException;

    List<Reserve> getReserveByIdClient(String idClient) throws TriddyServiceException;

    void addReserve(Reserve reserve);
}
