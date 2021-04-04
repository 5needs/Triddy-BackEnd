package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.User;

/**
 * @author Ricar8o
 */
public interface UserService {
    
    List<User> getUsers();
    User getUser(String email);
    User createUser(User user);
    void delUser(String user);
    void changeFullname(User user);
    void changeUniversity(User user);
    void changeCareer(User user);
    void changePicture(User user);
}
