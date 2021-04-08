package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Reclaim;
import edu.eci.ieti.triddy.services.ReclaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ReclaimController {

    @Autowired
    ReclaimService reclaimService;

    @GetMapping("/reserves/{idClient}/client")
    public ResponseEntity<?> getReclaimById(@PathVariable String idReclaim) {
        try {
            Reclaim reclaim = reclaimService.getReclaimById(idReclaim);
            return new ResponseEntity<>(reclaim,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/reserves/{idReserve}/reserve")
    public ResponseEntity<?> getReclaimByIdClient(@PathVariable String idReclaim) {
        try {
            Reclaim reclaim = reclaimService.getReclaimByIdClient(idReclaim);
            return new ResponseEntity<>(reclaim,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/reclaims/{idReclaims}")
    public ResponseEntity<?> getReclaimByIdOferent(@PathVariable String idReclaim) {
        try {
            Reclaim reclaim = reclaimService.getReclaimByIdOferent(idReclaim);
            return new ResponseEntity<>(reclaim,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/reclaims/{idReclaim}/{idClient}/{idOferent}/{category}/{comment}")
    public ResponseEntity<?> addReclaim(@PathVariable String idReclaim, @PathVariable String idClient,@PathVariable String idOferent,@PathVariable String category,@PathVariable String comment) {
        reclaimService.addReclaim(new Reclaim(idReclaim, idClient, idOferent, category, comment));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/resereclaimsrves/{idReclaim}")
    public ResponseEntity<?> deleteReclaimByIdClient(@PathVariable String idReclaim) {
        try {
            reclaimService.deleteReclaimByIidReclaim(idReclaim);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
