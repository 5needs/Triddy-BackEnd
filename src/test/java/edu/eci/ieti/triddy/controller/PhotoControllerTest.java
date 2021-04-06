package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.repository.PhotoRepository;

@SpringBootTest
class PhotoControllerTest {
    
    @Autowired
    PhotoController photoController;
    
    @Autowired
    private PhotoRepository photoRepository;

    @AfterEach
    void deletePhotos(){
        photoRepository.deleteAll();
    }

    @Test
    void getPhotosTest(){
        ResponseEntity<List<Photo>> response = photoController.getPhotos();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void addPhotoTest() throws IOException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        ResponseEntity<String> response = photoController.addPhoto("test", multipartFile);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void getPhotoImageTest() throws IOException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        ResponseEntity<String> res = photoController.addPhoto("test", multipartFile);

        ResponseEntity<?> response = photoController.getPhotoImage(res.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getPhotoImageFailTest(){
        ResponseEntity<?> response = photoController.getPhotoImage("aaa111");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void getPhotoTitleTest() throws IOException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        ResponseEntity<String> res = photoController.addPhoto("test", multipartFile);

        ResponseEntity<String> response = photoController.getPhotoTitle(res.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getPhotoTitleFailTest(){
        ResponseEntity<String> response = photoController.getPhotoTitle("aaa111");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void delPhotoTest() throws IOException{
        File file = File.createTempFile("test", ".jpg");
        MultipartFile multipartFile = new MockMultipartFile("test1.jpg", new FileInputStream(file));
        ResponseEntity<String> res = photoController.addPhoto("test", multipartFile);

        ResponseEntity<String> response = photoController.delPhoto(res.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());

        ResponseEntity<List<Photo>> photos = photoController.getPhotos();
        assertEquals(0, photos.getBody().size() );

    }

    @Test
    void delphotoFailTest(){
        ResponseEntity<String> response = photoController.delPhoto("aaa111");
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
