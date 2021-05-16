package edu.eci.ieti.triddy.controller;
import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RentControllerTest {
    @Autowired
    RentController rentController;

    @Test
    void postRentCreate() throws RentException {
        Rent rent = new Rent("initialDate", "finalDate", "status");
        ResponseEntity<?> response = rentController.createRent(rent);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void shouldRentException() {
        Rent rent = new Rent(null, null, null);
        ResponseEntity<?> response = rentController.createRent(rent);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }

    @Test
    void deleteRent() {
        Rent rent = new Rent("initialDate", "finalDate", "status");
        rentController.createRent(rent);
        ResponseEntity<?> response = rentController.deleteRent(rent.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void shouldDeleteException() {
        ResponseEntity<?> response = rentController.deleteRent("123");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}
