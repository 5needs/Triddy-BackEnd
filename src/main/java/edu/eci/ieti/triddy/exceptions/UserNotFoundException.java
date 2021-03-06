package edu.eci.ieti.triddy.exceptions;

public class UserNotFoundException extends Exception {

    private static final long serialVersionUID = 3844371229474477486L;

    public UserNotFoundException(String data) {
        super("Could not find user " + data);
    }
    
}
