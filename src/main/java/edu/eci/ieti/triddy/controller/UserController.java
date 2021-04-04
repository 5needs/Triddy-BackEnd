package edu.eci.ieti.triddy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @PostMapping
    public User postUser(@RequestBody User user){
        return userService.setUser(user);
    }

    @DeleteMapping("/{email}")
    public void delUser(@PathVariable String email){
        userService.delUser(email);;
    }
    
}
