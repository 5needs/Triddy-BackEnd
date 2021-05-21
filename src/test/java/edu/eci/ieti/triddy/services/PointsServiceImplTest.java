package edu.eci.ieti.triddy.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PointsServiceImplTest {

    @Autowired
    PointsService pointsService;

    @Test
    public void addPoints() {
        String points = "fff";
        pointsService.addPoints(points);
        assertNotNull(points);
    }

}