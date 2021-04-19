package edu.eci.ieti.triddy.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class User {
    @Id
    private String id;
    private String email;
    private String password;
    private String fullname;
    private String picture;
    private String university;
    private String career;
    private List<String> favorites;

    public User(String email, String password, String fullname, String university, String career, String picture, List<String> favorites) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.university = university;
        this.career = career;
        this.picture = picture;
        this.favorites = favorites;
    }
    
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return this.fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPicture() {
        return this.picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUniversity() {
        return this.university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCareer() {
        return this.career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public List<String> getFavorites() {
        return this.favorites;
    }

    public void setFavorites(List<String> favorites) {
        this.favorites = favorites;
    }


    @Override
    public String toString() {
        return String.format("User[ email='%s', password='%s', fullname='%s', university='%s', career='%s' ]",email,password,fullname,university,career);
    }

}
