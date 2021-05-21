package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Points;
import edu.eci.ieti.triddy.services.PointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api")
public class PointsController {

    @Autowired
    PointsService pointsService;

    @GetMapping("/points/{idClient}")
    public ResponseEntity<?> getPointsByIdClient(@PathVariable String idClient) {
        try {
            Points points = pointsService.getPointsByIdClient(idClient);
            return new ResponseEntity<>(points,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/points/{idClient}/{level}/{discount}/{category}")
    public ResponseEntity<?> addPoints(@PathVariable String idClient, @PathVariable String level,@PathVariable String discount,@PathVariable String category) {
        pointsService.addPoints(new Points(idClient, level, discount, category));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/points/{idClient}/{level}/{discount}/{category}")
    public ResponseEntity<?> improveLevelUserPoints(@PathVariable String idClient, @PathVariable String level,@PathVariable String discount,@PathVariable String category) {
        pointsService.improveLevelUserPoints(idClient, level, discount, category);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
