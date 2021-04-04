package edu.eci.ieti.triddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.services.UserService;

@RestController
@RequestMapping("/api/account")
public class AccountControler {
    
    @Autowired
    UserService userService;

    @PutMapping("/name")
    public void updateFullname(@RequestBody User user){
        userService.changeFullname(user);
    }
    @PutMapping("/university")
    public void updateUniversity(@RequestBody User user){
        userService.changeUniversity(user);
    }
    @PutMapping("/career")
    public void updateCareer(@RequestBody User user){
        userService.changeCareer(user);
    }
    @PutMapping("/picture")
    public void updatePicture(@RequestBody User user){
        userService.changePicture(user);
    }
}
