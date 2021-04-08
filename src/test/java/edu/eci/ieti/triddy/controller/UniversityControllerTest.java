package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Reserve;
import edu.eci.ieti.triddy.repository.ReserveRepository;
import edu.eci.ieti.triddy.services.ReserveService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class UniversityControllerTest {

    /*@Autowired
    ReserveService universityService;

    @Autowired
    ReserveRepository universityRepository;

    @Autowired
    ReserveController universityController;

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
        universityService.addUniversity(new Reserve("ECI"),"12237");
        ResponseEntity<?> response = universityController.getStudentsByUniversity("ECI");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotGetStudentsByUniversity(){
        ResponseEntity<?> response = universityController.getStudentsByUniversity("ECIfgsdfasd");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void updateStudentByUniversity(){
        universityService.addUniversity(new Reserve("ECI"),"12237");
        ResponseEntity<?> response = universityController.updateStudentByUniversity("ECI","12237");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotPpdateStudentByUniversity(){
        universityService.addUniversity(new Reserve("ECI"),"12237");
        ResponseEntity<?> response = universityController.updateStudentByUniversity("ECI456745674567","12237");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void deleteUniversityById(){
        universityService.addUniversity(new Reserve("ECI"),"12237");
        ResponseEntity<?> response = universityController.deleteUniversityById("ECI");
        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
    }

    @Test
    void shouldNotDeleteUniversityById(){
        ResponseEntity<?> response = universityController.deleteUniversityById("ECI6745674567");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }*/

}
