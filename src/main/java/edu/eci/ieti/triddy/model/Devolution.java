package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class Devolution {
    @Id
    private String id;
    private String idDevolution;
    private String stateDelivery;
    private String idUser;
    private String idClient;
    private String idProduct;
    private String dateTime;
    private String comments;


    public Devolution(String idDevolution, String stateDelivery, String idUser, String idClient, String idProduct, String dateTime, String comments) {
        this.idDevolution = idDevolution;
        this.stateDelivery = stateDelivery;
        this.idUser = idUser;
        this.idClient = idClient;
        this.idProduct = idProduct;
        this.dateTime = dateTime;
        this.comments = comments;
    }

    public Devolution(){
    }

    public String getIdDevolution() {
        return idDevolution;
    }

    public void setIdDevolution(String idDevolution) {
        this.idDevolution = idDevolution;
    }

    public String getStateDelivery() {
        return stateDelivery;
    }

    public void setStateDelivery(String stateDelivery) {
        this.stateDelivery = stateDelivery;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
