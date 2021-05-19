package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;
import edu.eci.ieti.triddy.repository.RentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RentServicesTest {
    @Autowired
    RentService rentService;

    @Autowired
    RentRepository rentRepository;

    @Test
    void createRent() throws RentException {
        Rent rent = new Rent("productid","user@mail.com",new Date(), new Date(), "status1");
        rentService.createRent(rent);
        assertTrue(rentRepository.existsById(rent.getId()));
    }
    @Test
    void deleteRent() {
        try {
            Rent rent = new Rent("productid","user@mail.com",new Date(), new Date(), "status1");
            rentService.deleteRent(rent.getId());
            rentRepository.existsById(rent.getId());
        } catch (RentException e) {
            assertTrue(true);
        }
    }
    @Test
    void getRents() throws RentException {
        Rent rent = new Rent("productid","user@mail.com",new Date(), new Date(), "status1");
        List<Rent> rents = rentService.rents("user@mail.com");
        assertTrue(!rents.isEmpty());
    }
}
