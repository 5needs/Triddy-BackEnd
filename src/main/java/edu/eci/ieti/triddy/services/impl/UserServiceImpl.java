package edu.eci.ieti.triddy.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
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
    public User getUser(String email) throws UserNotFoundException {
        User res = userRepository.findByEmail(email);
        if (res != null){
            return res;
        }else{
            throw new UserNotFoundException(email);
        }
    }

    @Override
    public User createUser(User user) throws TriddyServiceException {
        User res = userRepository.findByEmail(user.getEmail());
        if (res == null){
            user.setPassword(new Sha512Hash(user.getPassword()).toHex());
            return userRepository.save(user);
        }else{
            throw new TriddyServiceException("User already exist");
        }
        
    }

    @Override
    public void delUser(String user) throws UserNotFoundException {
        User res = userRepository.findByEmail(user);
        if (res != null){
            userRepository.deleteByEmail(user);
        }else{
            throw new UserNotFoundException(user);
        }
    }

    @Override
    public void changeFullname(User user) throws UserNotFoundException {
        User res = userRepository.findByEmail(user.getEmail());
        if (res != null){
            res.setFullname(user.getFullname());
            userRepository.save(res);
        }else{
            throw new UserNotFoundException(user.getEmail());
        }
        
        
    }

    @Override
    public void changeUniversity(User user) throws UserNotFoundException {
        User res = userRepository.findByEmail(user.getEmail());
        if (res != null){
            res.setUniversity(user.getUniversity());
            userRepository.save(res);  
        }else{
            throw new UserNotFoundException(user.getEmail());
        }  
    }

    @Override
    public void changeCareer(User user) throws UserNotFoundException {
        User res = userRepository.findByEmail(user.getEmail());
        if (res != null){
            res.setCareer(user.getCareer());
            userRepository.save(res); 
        }else{
            throw new UserNotFoundException(user.getEmail());
        }  
           
    }

    @Override
    public void changePicture(User user) throws UserNotFoundException {
        User res = userRepository.findByEmail(user.getEmail()); 
        if (res != null){
            res.setPicture(user.getPicture());
            userRepository.save(res);  
        }else{
            throw new UserNotFoundException(user.getEmail());
        }   
    }

    @Override
    public void changeFavorites(String user, List<String> favorites) throws UserNotFoundException {
        User res = userRepository.findByEmail(user); 
        if (res != null){
            res.setFavorites(favorites);
            userRepository.save(res);  
        }else{
            throw new UserNotFoundException(user);
        }   
    }
    
}
