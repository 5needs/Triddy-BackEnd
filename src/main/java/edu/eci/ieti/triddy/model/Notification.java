package edu.eci.ieti.triddy.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Notification {
    @Id
    private String id;
    private String user;
    private String type;
    private Date date;
    private String content;
    private String link;

    public Notification(String user, String type, Date date, String content, String link) {
        this.user = user;
        this.type = type;
        this.date = date;
        this.content = content;
        this.link = link;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return String.format("Notification[ id= '%s', user= '%s', type= '%s', date='%s', content='%s', link='%s']",id,user,type,date,content,link);
    }

}
