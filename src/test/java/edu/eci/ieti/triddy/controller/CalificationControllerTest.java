package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.Calification;

@SpringBootTest
class CalificationControllerTest {

    @Autowired
    CalificationController calificationController;

    @Test
    void testCalificationsFromUser(){
        Calification calification = new Calification("user1", "product", 2.5, 2.5, "comment", "user2", 2.5, "coment");
        calificationController.addCalification(calification);
        calification = new Calification("user3", "product", 2.5, 2.5, "comment", "user2", 2.5, "coment");
        calificationController.addCalification(calification);
        ResponseEntity<?> resp= calificationController.getCalificationsFromUser("user2");
        List<?> califications = (List<?>) resp.getBody();
        assertEquals(2, califications.size());
    }

    @Test
    void testCalificationsFromProduct(){
        Calification calification = new Calification("user4", "product2", 2.5, 2.5, "comment", "user5", 2.5, "coment");
        calificationController.addCalification(calification);
        calification = new Calification("user6", "product2", 2.5, 2.5, "comment", "user5", 2.5, "coment");
        calificationController.addCalification(calification);
        ResponseEntity<?> resp= calificationController.getCalificationsFromProduct("product2");
        List<?> califications = (List<?>) resp.getBody();
        assertEquals(2, califications.size());
    }

    @Test
    void testCalificationsByUser(){
        Calification calification = new Calification("user5", "product", 2.5, 2.5, "comment", "user6", 2.5, "coment");
        calificationController.addCalification(calification);
        calification = new Calification("user5", "product", 2.5, 2.5, "comment", "user4", 2.5, "coment");
        calificationController.addCalification(calification);
        ResponseEntity<?> resp= calificationController.getCalificationsFromQualifier("user5");
        List<?> califications = (List<?>) resp.getBody();
        assertEquals(2, califications.size());
    }

    @Test
    void testPointsOfProductAndUser(){
        Calification calification = new Calification("user", "product3", 5.0, 1.0, "comment", "user7", 4.0, "coment");
        calificationController.addCalification(calification);
        calification = new Calification("user", "product3", 3.0, 3.0, "comment", "user7", 2.0, "coment");
        calificationController.addCalification(calification);
        ResponseEntity<?> resp = calificationController.getProductStatus("product3");
        Double status = (Double) resp.getBody();
        assertEquals(4.0, status);
        resp = calificationController.getProductCharacteristic("product3");
        Double chara = (Double) resp.getBody();
        assertEquals(2.0, chara);
        resp = calificationController.getUserCalification("user7");
        Double calificationUser = (Double) resp.getBody();
        assertEquals(3.0, calificationUser);

    }

    @Test
    void testPointsOfNonExistentProductAndUser(){
        ResponseEntity<?> resp = calificationController.getProductStatus("product4");
        Double status = (Double) resp.getBody();
        assertEquals(2.5, status);
        resp = calificationController.getProductCharacteristic("product4");
        Double chara = (Double) resp.getBody();
        assertEquals(2.5, chara);
        resp = calificationController.getUserCalification("user8");
        Double calificationUser = (Double) resp.getBody();
        assertEquals(2.5, calificationUser);

    }





    
}
