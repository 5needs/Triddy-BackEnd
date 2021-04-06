package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.bson.types.Binary;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TriddyPhotoTest {
    @Test
    void createPhotoTest(){
        Photo photo = new Photo("Test Photo");
        assertEquals("Test Photo", photo.getTitle());
        assertNull(photo.getId());
        assertNull(photo.getImage());
    }

    @Test
    void SetsPhotoTest(){
        Photo photo = new Photo("Test Photo");
        assertEquals("Test Photo", photo.getTitle());

        byte[] data = "".getBytes();
        Binary image = new Binary(data);
        photo.setImage(image);
        assertEquals(image, photo.getImage());

        photo.setTitle("example");
        assertEquals("example", photo.getTitle());
    }
}
