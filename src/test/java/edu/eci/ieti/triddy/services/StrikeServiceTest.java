package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.UserStrike;
import edu.eci.ieti.triddy.repository.StrikeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StrikeServiceTest {

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
    public void  getUserStrike(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        try {
            assertNotEquals(null, strikeService.getUserStrike("test@gmail.com"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void  getUserStrikeFailed(){
        try {
            strikeService.getUserStrike("test@gmail.com");
        } catch (TriddyServiceException e) {
            assertEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        }
    }

    @Test
    public void getStrikeByActive(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        assertEquals(false,strikeService.getStrikeByActive(true).isEmpty());
    }

    @Test
    public void addUserStrike(){
        try {
            strikeService.addUserStrike("test@gmail.com");
            assertNotEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUserStrikeFailed(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        try {
            strikeService.addUserStrike("test@gmail.com");
        } catch (TriddyServiceException e) {
            assertNotEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        }
    }

    @Test
    public void addStrikeToUser(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        try {
            strikeService.addStrikeToUser(new UserStrike("test@gmail.com", temp,true));
            assertNotEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addStrikeToUserFailed() {
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        try {
            strikeService.addStrikeToUser(new UserStrike("test@gmail.com", temp, true));
        } catch (TriddyServiceException e) {
            assertEquals(null, strikeRepository.findByIdUser("test@gmail.com"));
        }
    }

    @Test
    public void changeActiveStrike(){
        UserStrike userStrike = new UserStrike("test@gmail.com", new ArrayList<>(),true);
        strikeRepository.save(userStrike);
        try {
            strikeService.changeActiveStrike("test@gmail.com");
            assertNotEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void changeActiveStrikeFailed() {
        try {
            strikeService.changeActiveStrike("test@gmail.com");
        } catch (TriddyServiceException e) {
            assertEquals(null, strikeRepository.findByIdUser("test@gmail.com"));
        }
    }

    @Test
    public void removeStrikeToUser(){
        List<String> temp = new ArrayList<>();
        temp.add("testing");
        UserStrike userStrike = new UserStrike("test@gmail.com", temp,true);

        strikeRepository.save(userStrike);
        try {
            strikeService.removeStrikeToUser("test@gmail.com",0);
            assertNotEquals(null,strikeRepository.findByIdUser("test@gmail.com"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeStrikeToUserFailed() {
        try {
            strikeService.removeStrikeToUser("test@gmail.com",0);
        } catch (TriddyServiceException e) {
            assertEquals(null, strikeRepository.findByIdUser("test@gmail.com"));
        }
    }
}
