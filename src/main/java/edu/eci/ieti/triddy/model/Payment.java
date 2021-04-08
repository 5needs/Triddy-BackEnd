package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class Payment {

    @Id
    private String id;
    private String idPayment;
    private Double price;
    private String idClient;
    private String idProduct;

    public Payment(String idPayment, Double price, String idClient,String idProduct ) {
        this.idPayment = idPayment;
        this.price = price;
        this.idClient = idClient;
        this.idProduct = idProduct;
    }

    public Payment() {
    }

    public String getIdPayment() {
        return idPayment;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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

    @Override
    public String toString() {
        return String.format("Payment[ idPayment='%s', price='%s', idClient='%s', idProduct='%s']",idPayment,price,idClient,idProduct);
    }

}


