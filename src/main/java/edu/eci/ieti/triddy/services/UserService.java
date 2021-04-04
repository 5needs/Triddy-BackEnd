package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.User;

/**
 * @author Ricar8o
 */
public interface UserService {
    
    List<User> getUsers();
    User getUser(String email) throws UserNotFoundException;
    User createUser(User user) throws TriddyServiceException;
    void delUser(String user) throws UserNotFoundException;
    void changeFullname(User user) throws UserNotFoundException;
    void changeUniversity(User user) throws UserNotFoundException;
    void changeCareer(User user) throws UserNotFoundException;
    void changePicture(User user) throws UserNotFoundException;
    void changeFavorites(String user, List<String> favorites) throws UserNotFoundException;
}
