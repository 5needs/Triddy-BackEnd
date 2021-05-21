package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Points;
import edu.eci.ieti.triddy.repository.PointsRepository;
import edu.eci.ieti.triddy.services.PointsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class PointsControllerTest {

    @Autowired
    PointsService pointsService;

    @Autowired
    PointsRepository pointsRepository;

    @Autowired
    PointsController pointsController;

    @AfterEach
    void deleteReserves(){
        pointsRepository.deleteAll();
    }

    @Test
    void addPoints(){
        ResponseEntity<?> response = pointsController.addPoints("12345678","4","4000","Primera Vez");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getPointsByIdClient(){
        pointsService.addPoints(new Points("123456789","4","4000","Primera Vez"));
        ResponseEntity<?> response = pointsController.getPointsByIdClient("123456789");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetPointsByIdClient(){
        ResponseEntity<?> response = pointsController.getPointsByIdClient("1234567891022");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void improveLevelUserPoints(){
        pointsService.addPoints(new Points("123456789","4","4000","Primera Vez"));
        ResponseEntity<?> response = pointsController.improveLevelUserPoints("123456789","4","4000","Primera Vez");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

}
