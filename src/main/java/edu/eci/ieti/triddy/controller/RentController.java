package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.RentException;
import edu.eci.ieti.triddy.model.Rent;
import edu.eci.ieti.triddy.services.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/rents")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping(value = "/create")
    public ResponseEntity<String> createRent(@RequestBody Rent rent) {
        try {
            rentService.createRent(rent);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteRent(@PathVariable String id) {
        try {
            rentService.deleteRent(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (RentException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
