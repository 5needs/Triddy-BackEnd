package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;

import java.util.List;

public interface RentService {
    void createRent(Rent rent) throws RentException;
    void deleteRent(String id) throws RentException;
    List<Rent> rents(String userEmail) throws RentException;
}
