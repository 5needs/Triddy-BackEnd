package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reserve;
import edu.eci.ieti.triddy.services.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReserveController {

    @Autowired
    ReserveService reserveService;

    @GetMapping("/reserves/{idClient}/client")
    public ResponseEntity<?> getReserveByIdClient(@PathVariable String idClient) {
        try {
            List<Reserve> reserve = reserveService.getReserveByIdClient(idClient);
            return new ResponseEntity<>(reserve,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/reserves/{idReserve}/reserve")
    public ResponseEntity<?> getReserveByIdReserve(@PathVariable String idReserve) {
        try {
            Reserve reserve = reserveService.getReserveByIdReserve(idReserve);
            return new ResponseEntity<>(reserve,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }


    @PostMapping("/reserves/{idReserve}/{idClient}/{idProduct}/{startDate}/{endDate}")
    public ResponseEntity<?> addReserve(@PathVariable String idReserve, @PathVariable String idClient,@PathVariable String idProduct,@PathVariable String startDate,@PathVariable String endDate) {
        reserveService.addReserve(new Reserve(idReserve, idClient, idProduct, startDate, endDate));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/reserves/{idReserve}")
    public ResponseEntity<?> deleteReserveByIdReserve(@PathVariable String idReserve) {
        try {
            reserveService.deleteReserveByIdReserve(idReserve);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }



}
