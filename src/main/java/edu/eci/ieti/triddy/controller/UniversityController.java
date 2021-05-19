package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.University;
import edu.eci.ieti.triddy.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class UniversityController {

    @Autowired
    UniversityService universityService;

    @GetMapping("/universities/{idUniversity}")
    public ResponseEntity<?> getStudentsByUniversity(@PathVariable String idUniversity) {
        try {
            ArrayList<String> students = universityService.getStudentsByUniversity((idUniversity));
            return new ResponseEntity<>(students,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/universities/{idUniversity}/{idClient}/{semester}")
    public ResponseEntity<?> addStudentToUniversity(@PathVariable String idUniversity, @PathVariable String idClient) {
        universityService.addUniversity(new University(idUniversity),idClient);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/universities/{idUniversity}/{idClient}")
    public ResponseEntity<?> updateStudentByUniversity(@PathVariable String idUniversity, @PathVariable String idClient) {
        try {
            universityService.updateStudentByUniversity(idUniversity,idClient);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/universities/{idUniversity}")
    public ResponseEntity<?> deleteUniversityById(@PathVariable String idUniversity) {
        try {
            universityService.deleteUniversityById(idUniversity);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }



}
