package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

public class Reclaim {

    @Id
    private String id;
    private String idReclaim;
    private String idClient;
    private String idOferent;
    private String category;
    private String comment;

    public Reclaim(String idReclaim, String idClient, String idOferent, String category, String comment){
        this.idReclaim=idReclaim;
        this.idClient=idClient;
        this.idOferent=idOferent;
        this.category=category;
        this.comment= comment;
    }

    public String getIdReclaim() {
        return idReclaim;
    }

    public String getIdClient() {
        return idClient;
    }

    public String getIdOferent() {
        return idOferent;
    }

    public String getCategory() {
        return category;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        return String.format("Reclaim[ idReclaim='%s', idClient='%s', idOferent='%s', category='%s', comment='%s']",idReclaim,idClient,idOferent,category,comment);
    }
}