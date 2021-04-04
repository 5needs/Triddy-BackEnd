package edu.eci.ieti.triddy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;
import edu.eci.ieti.triddy.services.UserService;

import org.apache.shiro.crypto.hash.Sha512Hash;

/**
 * @author Ricar8o
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User createUser(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        if (res == null){
            user.setPassword(new Sha512Hash(user.getPassword()).toHex());
            return userRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public void delUser(String user) {
        userRepository.deleteByEmail(user);
    }

    @Override
    public void changeFullname(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        res.setFullname(user.getFullname());
        userRepository.save(res);
    }

    @Override
    public void changeUniversity(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        res.setUniversity(user.getUniversity());
        userRepository.save(res);    
    }

    @Override
    public void changeCareer(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        res.setCareer(user.getCareer());
        userRepository.save(res);    
    }

    @Override
    public void changePicture(User user) {
        User res = userRepository.findByEmail(user.getEmail());
        res.setPicture(user.getPicture());
        userRepository.save(res);    
    }
    
}
