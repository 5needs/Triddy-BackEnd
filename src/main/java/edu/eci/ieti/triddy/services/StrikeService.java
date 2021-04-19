package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.UserStrike;

import java.util.List;

public interface StrikeService {

    public UserStrike getUserStrike(String idUser) throws TriddyServiceException;

    List<UserStrike> getStrikeByActive(Boolean active);

    void addUserStrike(String idUser) throws TriddyServiceException;

    void addStrikeToUser(UserStrike userStrike) throws TriddyServiceException;

    void changeActiveStrike(String idUser) throws TriddyServiceException;

    void removeStrikeToUser(String idUser,int strikePosition) throws TriddyServiceException;



}
