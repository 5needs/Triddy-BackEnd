package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Reclaim;
import edu.eci.ieti.triddy.repository.ReclaimRepository;
import edu.eci.ieti.triddy.services.ReclaimService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class ReserveControllerTest {

    @Autowired
    ReclaimService reserveService;

    @Autowired
    ReclaimRepository reserveRepository;

    @Autowired
    ReclaimController reserveController;

    @AfterEach
    void deleteReserves(){
        reserveRepository.deleteAll();
    }

    @Test
    void addReserve(){
        ResponseEntity<?> response = reserveController.addReserve("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getReserveByIdClient(){
        reserveService.addReserve(new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z"));
        ResponseEntity<?> response = reserveController.getReserveByIdClient("12");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetReserveByIdClient(){
        ResponseEntity<?> response = reserveController.getReserveByIdClient("ECIfgsdfasd");
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getReserveByIdReserve(){
        reserveService.addReserve(new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z"));
        ResponseEntity<?> response = reserveController.getReserveByIdReserve("123");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetReserveByIdReserve(){
        ResponseEntity<?> response = reserveController.getReserveByIdReserve("123HUIHNI9ON");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void deleteReserveByIdReserve(){
        reserveService.addReserve(new Reclaim("123","12","789","2021-04-01T19:52:00Z","2021-05-01T19:52:00Z"));
        ResponseEntity<?> response = reserveController.deleteReserveByIdReserve("123");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotDeleteReserveByIdReserve(){
        ResponseEntity<?> response = reserveController.deleteReserveByIdReserve("ECI6745674567");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

}
