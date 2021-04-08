package edu.eci.ieti.triddy.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class UserStrike {
    @Id
    private String id;
    private String idUser;
    private List<String> strikes;
    private boolean active;

    public UserStrike(String idUser, List<String> strikes, boolean active) {
        this.idUser = idUser;
        this.strikes = strikes;
        this.active = active;
    }

    public UserStrike() {
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public List<String> getStrikes() {
        return strikes;
    }

    public void setStrikes(List<String> strikes) {
        this.strikes = strikes;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void removeStrike(int position){
        if (!(strikes.isEmpty())){
            strikes.remove(position);
        }
    }
}
