package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.exceptions.UserNotFoundException;
import edu.eci.ieti.triddy.model.User;
import edu.eci.ieti.triddy.repository.UserRepository;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    
    @Test
    void getUsersTest(){
        assertNotNull(userService.getUsers());
    }
    @AfterEach
    void deleteUsers(){
        userRepository.deleteAll();
    }

    @Test
    void createAndgetUserTest() throws UserNotFoundException, TriddyServiceException{
        User user1 = userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User user2 = userService.getUser("test@mail.com");
        assertNotNull(user1);
        assertNotNull(user2);
    }

    @Test
    void createRepeatedUserTest(){
        try {
            User user = userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
            assertNotNull(user);
            userService.createUser(new User("test@mail.com", "abc789", "Test other", "other U", "other career", null, null, "CC", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("User already exist",e.getMessage());
        }
    }

    @Test
    void createRepeatedUserTest2(){
        try {
            User user = userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
            assertNotNull(user);
            userService.createUser(new User("test2@mail.com", "abc789", "Test other", "other U", "other career", null, null, "CC", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("User already exist",e.getMessage());
        }
    }

    @Test 
    void createUserEmptyEmailTest(){
        try {
            userService.createUser(new User(null, "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("Incomplete or empty user data",e.getMessage());
        }
    }
    @Test 
    void createUserEmptyPasswordTest(){
        try {
            userService.createUser(new User("test@mail.com", null, "Test other", "other U", "other career", null, null, "CC", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("Incomplete or empty user data",e.getMessage());
        }
    }
    @Test 
    void createUserEmptyNameTest(){
        try {
            userService.createUser(new User("test@mail.com", "abc789", null, "other U", "other career", null, null,"CC", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("Incomplete or empty user data",e.getMessage());
        }
    }

    @Test 
    void createUserEmptyDocNumTest(){
        try {
            userService.createUser(new User("test@mail.com", "abc789", "Test other", "other U", "other career", null, null,"CC", null));
        } catch (TriddyServiceException e) {
            assertEquals("Incomplete or empty user data",e.getMessage());
        }
    }

    @Test 
    void createUserNotValidDocTypeTest(){
        try {
            userService.createUser(new User("test@mail.com", "abc789", "Test other", "other U", "other career", null, null,"AA", "123456789"));
        } catch (TriddyServiceException e) {
            assertEquals("Incomplete or empty user data",e.getMessage());
        }
    }

    @Test
    void getNotValidUserTest(){
        try {
            userService.getUser("test@mail.com");
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

    @Test
    void delValidUserTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User user = userService.getUser("test@mail.com");
        assertNotNull(user);
        userService.delUser("test@mail.com");
        List<User> users= userService.getUsers();
        assertEquals(0, users.size());
    }

    @Test
    void delNotValidUserTest(){
        try {
            userService.delUser("test@mail.com");
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

    @Test
    void changeNameTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User newName = new User("test@mail.com", null, "New Name", null, null, null, null, null, null);
        userService.changeFullname(newName);
        User user = userService.getUser("test@mail.com");
        assertEquals("New Name", user.getFullname());
    }

    @Test
    void changeNameExceptionTest() {
        User newName = new User("test@mail.com", null, "New Name", null, null, null, null, null, null);
        try {
            userService.changeFullname(newName);
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

    @Test
    void changeUniversityTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User other = new User("test@mail.com", null, null, "Other uni", null, null, null, null, null);
        userService.changeUniversity(other);
        User user = userService.getUser("test@mail.com");
        assertEquals("Other uni", user.getUniversity());
    }

    @Test
    void changeUniversityExceptionTest() {
        User other = new User("test@mail.com", null, null, "Other uni", null, null, null, null, null);
        try {
            userService.changeUniversity(other);
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }
    @Test
    void changeCareerTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User other = new User("test@mail.com", null, null, null, "Other career", null, null, null, null);
        userService.changeCareer(other);
        User user = userService.getUser("test@mail.com");
        assertEquals("Other career", user.getCareer());
    }

    @Test
    void changeCareerExceptionTest() {
        User other = new User("test@mail.com", null, null, null, "Other career", null, null, null, null);
        try {
            userService.changeCareer(other);
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

    @Test
    void changePictureTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, null, "CC", "123456789"));
        User other = new User("test@mail.com", null, null, null, null, "http://example.jpg", null, null, null);
        userService.changePicture(other);
        User user = userService.getUser("test@mail.com");
        assertEquals("http://example.jpg", user.getPicture());
    }

    @Test
    void changePictureExceptionTest() {
        User other = new User("test@mail.com", null, null, null, null, "http://example.jpg", null, null, null);
        try {
            userService.changePicture(other);
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

    @Test
    void changeFavoritesTest() throws TriddyServiceException, UserNotFoundException{
        userService.createUser(new User("test@mail.com", "abc123", "Test User", "test U", "test career", null, new ArrayList<String>(), "CC", "123456789"));
        List<String> data = new ArrayList<String>();
        data.add("aaaaa");
        userService.changeFavorites("test@mail.com", data);
        User user = userService.getUser("test@mail.com");
        assertEquals(1, user.getFavorites().size());
    }

    @Test
    void changeFavoritesExceptionTest() {
        try {
            userService.changeFavorites("test@mail.com", new ArrayList<String>());
        } catch (UserNotFoundException e) {
            assertEquals("Could not find user test@mail.com",e.getMessage());
        }
    }

}
