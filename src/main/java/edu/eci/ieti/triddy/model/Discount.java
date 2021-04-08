package edu.eci.ieti.triddy.model;

import java.util.Date;

public class Discount {
    public String product;
    public Date start;
    public Date end;
    public String type;

    public Discount(String product, Date start, Date end, String type){
        this.product = product;
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public Discount(){
        
    }

    public String getProduct() {
        return this.product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Date getStart() {
        return this.start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return this.end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Discount[ product= '%s', type= '%s', start= '%s', end= '%s']"  
        ,this.product,this.type,this.start,this.end);
    } 
    
}
