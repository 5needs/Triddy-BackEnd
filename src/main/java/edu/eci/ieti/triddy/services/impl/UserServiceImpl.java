package edu.eci.ieti.triddy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;
import edu.eci.ieti.triddy.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User setUser(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        if (res == null){
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public void delUser(String user) {
        userRepository.deleteByEmail(user);
    }
    
}
