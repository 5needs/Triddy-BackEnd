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
public class UniversityControllerTest {

    @Autowired
    ReclaimService reclaimService;

    @Autowired
    ReclaimRepository reclaimRepository;

    @Autowired
    ReclaimController reclaimController;

    @AfterEach
    void deleteReclaims(){
        reclaimRepository.deleteAll();
    }

    @Test
    void addReclaim(){
        ResponseEntity<?> response = reclaimController.addReclaim("12","13","14","robo","muy malo todo");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getReclaimById(){
        reclaimService.addReclaim(new Reclaim("12","13","14","robo","muy malo todo"));
        ResponseEntity<?> response = reclaimController.getReclaimById("12");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetReclaimById(){
        ResponseEntity<?> response = reclaimController.getReclaimById("ECIfgsdfasd");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void getReclaimByIdClient(){
        reclaimService.addReclaim(new Reclaim("12","13","14","robo","muy malo todo"));
        ResponseEntity<?> response = reclaimController.getReclaimByIdClient("13");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetReclaimByIdClient(){
        ResponseEntity<?> response = reclaimController.getReclaimByIdClient("ECI456745674567");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void getReclaimByIdOferent(){
        reclaimService.addReclaim(new Reclaim("12","13","14","robo","muy malo todo"));
        ResponseEntity<?> response = reclaimController.getReclaimByIdOferent("14");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetReclaimByIdOferent(){
        ResponseEntity<?> response = reclaimController.getReclaimByIdOferent("ECI6745674567");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void deleteReclaimByIidReclaim(){
        reclaimService.addReclaim(new Reclaim("12","13","14","robo","muy malo todo"));
        ResponseEntity<?> response = reclaimController.deleteReclaimByIidReclaim("12");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotDeleteReclaimByIidReclaim(){
        ResponseEntity<?> response = reclaimController.deleteReclaimByIidReclaim("ECI6745674567");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

}
