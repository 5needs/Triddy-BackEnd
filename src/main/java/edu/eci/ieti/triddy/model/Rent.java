package edu.eci.ieti.triddy.model;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

public class Rent {
    @Id
    private String id;
    private String userEmail;
    private String productId;
    private Date initialDate;
    private Date finalDate;
    private String status;
    public Rent(String productId, String userEmail, Date initialDate, Date finalDate, String status) {
        setId();
        this.productId = productId;
        this.userEmail = userEmail;
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
    public Date getInitialDate() {
        return initialDate;
    }
    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }
    public Date getFinalDate() {
        return finalDate;
    }
    public void setFinalDate(Date finalDate) {
        this.finalDate = finalDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserId(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
}
