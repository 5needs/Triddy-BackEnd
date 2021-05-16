package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;

public interface RentService {
    void createRent(Rent rent) throws RentException;
    void deleteRent(String id) throws RentException;
}
