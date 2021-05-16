package edu.eci.ieti.triddy.controller;
import edu.eci.ieti.triddy.model.UserStrike;
import edu.eci.ieti.triddy.repository.StrikeRepository;
import edu.eci.ieti.triddy.services.StrikeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
class StrikeControllersTest {

    @Autowired
    StrikeControllers strikeControllers;

    @Autowired
    StrikeRepository strikeRepository;

    @Autowired
    @Qualifier("strikeService")
    StrikeService strikeService;

    @AfterEach
    public void strikeRestart(){
        strikeRepository.deleteAll();
    }

    @Test
    public void getStrikeByActive(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        ResponseEntity<List<UserStrike>> responseEntity  =strikeControllers.getStrikeByActive(true);
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void getUserStrike(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        ResponseEntity<UserStrike> responseEntity  =strikeControllers.getUserStrike("test@gmail.com");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void getUserStrikeFailed(){
        ResponseEntity<UserStrike> responseEntity  =strikeControllers.getUserStrike("test@gmail.com");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void addUserStrike(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        ResponseEntity<String> responseEntity  =strikeControllers.addUserStrike(userStrike.getIdUser());
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void addUserStrikeFailed(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        ResponseEntity<String> responseEntity  =strikeControllers.addUserStrike("test@gmail.com");
        assertEquals(HttpStatus.BAD_REQUEST,responseEntity.getStatusCode());
    }

    @Test
    public void addStrikeToUser(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        UserStrike userStrike1 = new UserStrike("test@gmail.com", temp,true);
        ResponseEntity<String> responseEntity  =strikeControllers.addStrikeToUser(userStrike1);
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void addStrikeToUserFailed(){
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        UserStrike userStrike1 = new UserStrike("test@gmail.com", temp,true);
        ResponseEntity<String> responseEntity  =strikeControllers.addStrikeToUser(userStrike1);
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void changeActiveStrike(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        ResponseEntity<String> responseEntity  =strikeControllers.changeActiveStrike("test@gmail.com");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void changeActiveStrikeFailed(){
        ResponseEntity<String> responseEntity  =strikeControllers.changeActiveStrike("test@gmail.com");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void removeStrikeToUser(){
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        UserStrike userStrike = new UserStrike("test@gmail.com", temp,true);
        strikeRepository.save(userStrike);
        ResponseEntity<String> responseEntity  =strikeControllers.removeStrikeToUser("test@gmail.com",0);
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void removeStrikeToUserFailed(){
        ResponseEntity<String> responseEntity  =strikeControllers.removeStrikeToUser("test@gmail.com",0);
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }
}