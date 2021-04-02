package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String email;
    private String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
    @Override
    public String toString() {
        return String.format("User [email= '%s', name= '%s']",email, name);
    }
    
}
