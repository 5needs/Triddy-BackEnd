package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.Payment;
import edu.eci.ieti.triddy.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @GetMapping("/payments/{idPayment}")
    public ResponseEntity<?> getPaymentById(@PathVariable String idPayment) {
        try {
            Payment payment = paymentService.getPaymentById((idPayment));
            return new ResponseEntity<>(payment,HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/payments/{idPayment}/{price}/{IdClient}/{idProduct}")
    public ResponseEntity<?> addPayment(@PathVariable String idPayment, @PathVariable Double price, @PathVariable String IdClient, @PathVariable String idProduct) {
        paymentService.addPayment(new Payment(idPayment,price,IdClient,idProduct));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/payments/{idPayment}")
    public ResponseEntity<?> deletePaymentById(@PathVariable String idPayment) {
        try {
            paymentService.deletePaymentById(idPayment);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (TriddyServiceException e) {
            Logger.getLogger(PaymentController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
