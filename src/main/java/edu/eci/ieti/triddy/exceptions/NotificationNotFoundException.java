package edu.eci.ieti.triddy.exceptions;

public class NotificationNotFoundException extends Exception {

    private static final long serialVersionUID = 5620096424768626470L;

    public NotificationNotFoundException(String id) {
        super("Could not find notification with id: " + id);
    }
    
}
