package edu.eci.ieti.triddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.services.UserService;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    
    @Autowired
    UserService userService;

    @PutMapping("/name")
    public ResponseEntity<String> updateFullname(@RequestBody User user){
        try {
            userService.changeFullname(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
    @PutMapping("/university")
    public ResponseEntity<String> updateUniversity(@RequestBody User user){
        try {
            userService.changeUniversity(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        
    }
    @PutMapping("/career")
    public ResponseEntity<String> updateCareer(@RequestBody User user){
        try {
            userService.changeCareer(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        
    }
    @PutMapping("/picture")
    public ResponseEntity<String> updatePicture(@RequestBody User user){
        try {
            userService.changePicture(user);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
