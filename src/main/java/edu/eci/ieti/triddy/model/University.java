package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.Locale;

public class University {

    @Id
    private String id;
    private String idUniversity;
    private long discount;
    private ArrayList<String> students;

    public University(String idUniversity){
        this.idUniversity=idUniversity;
        this.students= new ArrayList<>();
        this.discount=0;
    }

    public long getDiscount() {
        return discount;
    }

    public void setDiscount(String university) {
        if(university.toLowerCase(Locale.ROOT).equals("eci")){
            this.discount = 5000;
        }else{
            this.discount = 1000;
        }
    }

    public ArrayList<String> getStudents() {
        return students;
    }

    public void setStudents(String student) {
        this.students.add(student);
    }

    public String getIdUniversity() {
        return idUniversity;
    }

    public void setIdUniversity(String idUniversity) {
        this.idUniversity = idUniversity;
    }

    @Override
    public String toString() {
        return String.format("University[ idUniversity='%s', discount='%s', students='%s']",idUniversity,discount,students);
    }
}
