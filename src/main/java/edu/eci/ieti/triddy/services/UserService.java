package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.User;

/**
 * @author Ricar8o
 */
public interface UserService {
    
    List<User> getUsers();
    User getUser(String email);
    User setUser(User user);
    void delUser(String user);
}
