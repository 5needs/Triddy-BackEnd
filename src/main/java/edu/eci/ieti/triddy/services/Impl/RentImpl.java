package edu.eci.ieti.triddy.services.impl;
import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;
import edu.eci.ieti.triddy.repository.RentRepository;
import edu.eci.ieti.triddy.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentImpl implements RentService {
    @Autowired
    RentRepository rentRepository;

    @Override
    public void createRent(Rent rent) throws RentException {
        if(rent.getInitialDate() == null || rent.getFinalDate() == null || rent.getStatus() == null) {
            throw new RentException("error when creating the rent");
        } else {
            rentRepository.save(rent);
        }
    }

    @Override
    public void deleteRent(String id) throws RentException {
        if(rentRepository.existsById(id)) {
            rentRepository.deleteById(id);
        } else {
            throw new RentException("the rent does not exist");
        }
    }
}
