package edu.eci.ieti.triddy.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "Rent")
public class Rent {
    @Id
    private String id;
    private String initialDate;
    private String finalDate;
    private String status;
    public Rent(String initialDate, String finalDate, String status) {
        setId();
        this.initialDate = initialDate;
        this.finalDate = finalDate;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    public String getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(String initialDate) {
        this.initialDate = initialDate;
    }

    public String getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(String finalDate) {
        this.finalDate = finalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
