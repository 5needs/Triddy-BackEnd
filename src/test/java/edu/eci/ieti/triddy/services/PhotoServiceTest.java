package edu.eci.ieti.triddy.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.exceptions.TriddyPhotoException;
import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.repository.PhotoRepository;


@SpringBootTest
public class PhotoServiceTest {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private PhotoRepository photoRepository;

    @AfterEach
    void deletePhotos(){
        photoRepository.deleteAll();
    }

    @Test
    void getPhotosTest(){
        List<Photo> photos = photoService.getPhotos();
        assertNotNull(photos);
    }
    @Test
    void addAndGetPhotoTest() throws IOException, TriddyPhotoException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        String id = photoService.addPhoto("Test", multipartFile);
        assertNotNull(id);

        Photo response = photoService.getPhoto(id);

        assertNotNull(response);
    }

    @Test
    void getNotExistentPhotoTest() {
        try {
            photoService.getPhoto("aaa000");
        } catch (TriddyPhotoException e) {
            assertEquals("Photo not found", e.getMessage());
        }
    }

    @Test
    void deletePhotoTest() throws IOException, TriddyPhotoException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        String id = photoService.addPhoto("Test", multipartFile);
        assertNotNull(id);

        photoService.delPhoto(id);
    }

    @Test
    void deleteNotExistentPhotoTest(){
        try {
            photoService.delPhoto("aaa000");
        } catch (TriddyPhotoException e) {
            assertEquals("Photo not found", e.getMessage());
        }
    }
    
}
