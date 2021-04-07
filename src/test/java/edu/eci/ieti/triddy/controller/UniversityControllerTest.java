package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.University;
import edu.eci.ieti.triddy.repository.UniversityRepository;
import edu.eci.ieti.triddy.services.UniversityService;
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
    UniversityService universityService;

    @Autowired
    UniversityRepository universityRepository;

    @Autowired
    UniversityController universityController;

    @AfterEach
    void deletePayments(){
        universityRepository.deleteAll();
    }

    @Test
    void addStudentToUniversity(){
        ResponseEntity<?> response = universityController.addStudentToUniversity("ECI","1223");
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getStudentsByUniversity(){
        universityService.addUniversity(new University("ECI"),"12237");
        ResponseEntity<?> response = universityController.getStudentsByUniversity("ECI");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void updateStudentByUniversity(){
        universityService.addUniversity(new University("ECI"),"12237");
        ResponseEntity<?> response = universityController.updateStudentByUniversity("ECI","12237");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void deleteUniversityById(){
        universityService.addUniversity(new University("ECI"),"12237");
        ResponseEntity<?> response = universityController.deleteUniversityById("ECI");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

}
