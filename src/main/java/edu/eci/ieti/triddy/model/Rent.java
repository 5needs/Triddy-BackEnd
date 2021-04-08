package edu.eci.ieti.triddy.model;
import org.springframework.data.annotation.Id;
import java.util.UUID;

public class Rent {
    @Id
    private String id;
    private String userId;
    private String productId;
    private String initialDate;
    private String finalDate;
    private String status;
    public Rent(String initialDate, String finalDate, String status) {
        setId();
        setUserId();
        setProductId();
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
    public String getUserId() {
        return userId;
    }
    public void setUserId() {
        this.userId = "userId";
    }
    public String getProductId() {
        return productId;
    }
    public void setProductId() {
        this.productId = "productId";
    }
}
