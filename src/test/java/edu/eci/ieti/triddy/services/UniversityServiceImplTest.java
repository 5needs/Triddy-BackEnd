package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.controller.UniversityController;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.University;
import edu.eci.ieti.triddy.repository.UniversityRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UniversityServiceImplTest {

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
    public void addUniversity() {
        University university = new University("Javeriana");
        universityService.addUniversity(university, "4321");
        University university2 = universityRepository.findByIdUniversity("Javeriana");
        assertNotNull(university2.getIdUniversity());
    }

    @Test
    public void getStudentsByUniversity() {
        try {
            University university = new University("Javeriana");
            universityService.addUniversity(university, "4321");
            ArrayList<String> students = universityService.getStudentsByUniversity("Javeriana");
            assertTrue(students.contains("4321"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("University with Id:"));
        }
    }

    @Test
    public void updateStudentByUniversity() {
        try {
            University university = new University("Javeriana");
            universityService.addUniversity(university, "4321");
            universityService.updateStudentByUniversity("Javeriana","4321");
            ArrayList<String> students = universityService.getStudentsByUniversity("Javeriana");
            assertFalse(students.contains("4321"));
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("University with Id:"));
        }
    }

    @Test
    public void deleteUniversityById() {
        try {
            University university = new University("Javeriana");
            universityService.addUniversity(university, "4321");
            universityService.deleteUniversityById("Javeriana");
            University university2 = universityRepository.findByIdUniversity("Javeriana");
            assertNull(university2);
        }catch (TriddyServiceException e) {
            assertTrue(e.getMessage().contains("Payment with Id:"));
        }
    }


}
