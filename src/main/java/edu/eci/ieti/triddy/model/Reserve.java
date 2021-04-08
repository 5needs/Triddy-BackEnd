package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class Reserve {

    @Id
    private String id;
    private String idReserve;
    private String idClient;
    private String idProduct;
    private String startDate;
    private String endDate;

    public Reserve(String idReserve, String idClient, String idProduct, String startDate, String endDate){
        this.idReserve=idReserve;
        this.idClient=idClient;
        this.idProduct=idProduct;
        this.startDate=startDate;
        this.endDate= endDate;
    }

    public String getIdReserve() {
        return idReserve;
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return String.format("Reserve[ idReserve='%s', idClient='%s', idProduct='%s', startDate='%s', endDate='%s']",idReserve,idClient,idProduct,startDate,endDate);
    }
}
