package edu.eci.ieti.triddy.model;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "photos")
public class Photo {
    @Id
    private String id;
    
    private String title;
        
    private Binary image;

    private String type;


    public Photo(String title) {
        this.title = title;
    }

    public String getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Binary getImage() {
        return this.image;
    }

    public void setImage(Binary image) {
        this.image = image;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }

}