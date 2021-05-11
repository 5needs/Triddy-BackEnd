package edu.eci.ieti.triddy.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.Calification;
import edu.eci.ieti.triddy.services.CalificationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/califications")
public class CalificationController {
    @Autowired
    CalificationService calificationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Calification>> getCalificationsFromUser(@PathVariable String userId){
        List<Calification> califications = calificationService.getUserCalifications(userId);
        return new ResponseEntity<>(califications, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Calification>> getCalificationsFromProduct(@PathVariable String productId){
        List<Calification> califications = calificationService.getProductCalifications(productId);
        return new ResponseEntity<>(califications, HttpStatus.ACCEPTED);
    }

    @GetMapping("/qualifier/{qualifierId}")
    public ResponseEntity<List<Calification>> getCalificationsFromQualifier(@PathVariable String qualifierId){
        List<Calification> califications = calificationService.getCalificationsByUser(qualifierId);
        return new ResponseEntity<>(califications, HttpStatus.ACCEPTED);
    }

    @GetMapping("/status/{productId}")
    public ResponseEntity<Double> getProductStatus(@PathVariable String productId){
        Double status = calificationService.getProductStatus(productId);
        return new ResponseEntity<>(status, HttpStatus.ACCEPTED);
    }

    @GetMapping("/characteristic/{productId}")
    public ResponseEntity<Double> getProductCharacteristic(@PathVariable String productId){
        Double characteristic = calificationService.getProductCharacteristic(productId);
        return new ResponseEntity<>(characteristic, HttpStatus.ACCEPTED);
    }

    @GetMapping("/calification/{usertId}")
    public ResponseEntity<Double> getUserCalification(@PathVariable String userId){
        Double characteristic = calificationService.getUserCalification(userId);
        return new ResponseEntity<>(characteristic, HttpStatus.ACCEPTED);
    }

    @PostMapping
    public ResponseEntity<Calification> addCalification(@RequestBody Calification calification){
        Calification newCalification = calificationService.addCalification(calification);
        return new ResponseEntity<>(newCalification, HttpStatus.ACCEPTED);
    }







}
