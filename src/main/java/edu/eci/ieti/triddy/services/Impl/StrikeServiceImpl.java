package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.UserStrike;
import edu.eci.ieti.triddy.repository.StrikeRepository;
import edu.eci.ieti.triddy.services.StrikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("strikeService")
public class StrikeServiceImpl implements StrikeService {

    @Autowired
    StrikeRepository strikeRepository;

    @Override
    public UserStrike getUserStrike(String idUser) throws TriddyServiceException {
        UserStrike userStrike = strikeRepository.findByIdUser(idUser);
        if(userStrike == null){
            throw new TriddyServiceException("Strike Not Found");
        }
        return userStrike;
    }

    @Override
    public List<UserStrike> getStrikeByActive(Boolean active) {
        List<UserStrike> userStrikes = strikeRepository.findByActive(active);
        return userStrikes;
    }

    @Override
    public void addUserStrike(String idUser) throws TriddyServiceException {
        UserStrike userStrike = strikeRepository.findByIdUser(idUser);
        if(userStrike != null){
            throw new TriddyServiceException("Strike Already Exists");
        }
        UserStrike userStrike1 = new UserStrike(idUser, new ArrayList<>(),true);
        strikeRepository.save(userStrike1);
    }

    @Override
    public void addStrikeToUser(UserStrike userStrike) throws TriddyServiceException{
        UserStrike userStrike1 = strikeRepository.findByIdUser(userStrike.getIdUser());
        if(userStrike1 == null){
            throw new TriddyServiceException("Strike Not Found");
        }
        userStrike1.setStrikes(userStrike.getStrikes());
        strikeRepository.save(userStrike1);
    }

    @Override
    public void changeActiveStrike(String idUser) throws TriddyServiceException{
        UserStrike userStrike = strikeRepository.findByIdUser(idUser);
        if(userStrike == null){
            throw new TriddyServiceException("Strike Not Found");
        }
        userStrike.setActive(!(userStrike.isActive()));
        strikeRepository.save(userStrike);
    }

    @Override
    public void removeStrikeToUser(String idUser,int strikePosition) throws TriddyServiceException{
        UserStrike userStrike = strikeRepository.findByIdUser(idUser);
        if(userStrike == null){
            throw new TriddyServiceException("Strike Not Found");
        }
        userStrike.removeStrike(strikePosition);
        strikeRepository.save(userStrike);
    }
}
