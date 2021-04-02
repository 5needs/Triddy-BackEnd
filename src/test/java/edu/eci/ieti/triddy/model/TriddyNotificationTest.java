package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TriddyNotificationTest {

    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Test
	void createNotification() throws ParseException {
        Date date = dateFormat.parse("02-04-2021");
        Notification notification = new Notification("user@test.com", "Type1", date, "A content for test", "https://www.google.com/");
        assertEquals("A content for test",notification.getContent());
        assertEquals("user@test.com",notification.getUser());
        assertEquals("Type1",notification.getType());
        assertEquals(date, notification.getDate());
        assertEquals("https://www.google.com/",notification.getLink());
	}

    @Test
    void validSetIdAndDate() throws ParseException{
        Date date = dateFormat.parse("18-03-2021");
        Date date2 = dateFormat.parse("02-04-2021");
        Notification notification = new Notification("user@test.com", "Type1", date, "A content for test", "https://www.google.com/");
        assertNull(notification.getId());
        notification.setId("5sd65a6");
        assertEquals("5sd65a6",notification.getId());
        notification.setDate(date2);
        assertEquals(date2,notification.getDate());
    }

    @Test
    void validSetStringConstructorValues(){
        Notification notification = new Notification("user@test.com", "Type1", new Date(), "A content for test", "https://www.google.com/");
        notification.setContent("other Content");
        notification.setType("other type");
        notification.setUser("other user");
        notification.setLink("other link");

        assertEquals("other Content", notification.getContent());
        assertEquals("other type", notification.getType());
        assertEquals("other user", notification.getUser());
        assertEquals("other link", notification.getLink());
    }

    @Test
    void validToStringMethod(){
        Date date = new Date();
        String expected = String.format("Notification[ id= '%s', user= '%s', type= '%s', date='%s', content='%s', link='%s']",null,"user@test.com","Type1",date,"A content for test","https://www.google.com/");
        Notification notification = new Notification("user@test.com", "Type1", date, "A content for test", "https://www.google.com/");
        assertEquals(expected, notification.toString());
    }
    
}
