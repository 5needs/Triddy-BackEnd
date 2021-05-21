package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class Points {

    @Id
    private String id;
    private String level;
    private String idClient;
    private String discount;
    private String category;

    public Points(String idClient, String level, String discount, String category){
        this.level=level;
        this.idClient=idClient;
        this.discount=discount;
        this.category=category;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return String.format("Points[ idClient='%s', discount='%s', level='%s', category='%s']",idClient,discount,level,category);
    }
}
