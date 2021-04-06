package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID;

@Document(collection = "Product")
public class Product {
    @Id
    private String id;
    private String[] pictures;
    private String name;
    private String description;
    private Boolean available;

    public Product(String[] pictures, String description, String name) {
        setId();
        this.pictures = pictures;
        this.description = description;
        this.name = name;
        this.available = true;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        UUID uuid = UUID.randomUUID();
        this.id = uuid.toString();
    }

    public String[] getPictures() {
        return pictures;
    }

    public void setPictures(String[] pictures) {
        this.pictures = pictures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
