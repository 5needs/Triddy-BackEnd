package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.controller.PointsController;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Points;
import edu.eci.ieti.triddy.repository.PointsRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PointsServiceImplTest {

    @Autowired
    PointsService pointsService;

    @Autowired
    PointsRepository pointsRepository;

    @Autowired
    PointsController pointsController;

    @AfterEach
    void deletePayments(){
        pointsRepository.deleteAll();
    }

    @Test
    public void addPoints() {
        Points points = new Points("12345","2","3000","Referido");
        pointsService.addPoints(points);
        Points points2 = pointsRepository.findByIdClient("12345");
        assertNotNull(points2.getIdClient());
    }

    @Test
    public void getPointsByIdClient() {
        try {
            Points points = new Points("123456","1","1000","Fidelidad");
            pointsService.addPoints(points);
            Points points2 = pointsService.getPointsByIdClient("123456");
            assertTrue(points2.getIdClient().equals("123456"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Points with Id Client:"));
        }
    }

    @Test
    public void improveLevelUserPoints() {
        try {
            Points points = new Points("1234567","2","3000","Referido");
            pointsService.addPoints(points);
            pointsService.improveLevelUserPoints("1234567","4","1500","Mensualidad");
            Points points2 = pointsService.getPointsByIdClient("1234567");
            assertEquals(points2.getIdClient(),"1234567");
            assertTrue(!(points2.getLevel().equals(points.getLevel())));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Points with Id Client:"));
        }
    }

}