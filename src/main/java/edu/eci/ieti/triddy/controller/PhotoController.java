package edu.eci.ieti.triddy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.exceptions.TriddyPhotoException;
import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.services.PhotoService;

@RestController
@CrossOrigin(origins = "*")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping("/api/photos")
    public ResponseEntity<List<Photo>> getPhotos(){
        return new ResponseEntity<>( photoService.getPhotos(),HttpStatus.OK);
    }

    @PostMapping("/api/photos")
    public ResponseEntity<String> addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
        return new ResponseEntity<>(photoService.addPhoto(title, image), HttpStatus.CREATED);
    }

    @GetMapping("/photos/{id}")
    public ResponseEntity<byte[]> getPhotoImage(@PathVariable String id) {
        try {
            Photo photo = photoService.getPhoto(id);
            HttpHeaders headers = new HttpHeaders();
            byte[] media = photo.getImage().getData();
            headers.add("Content-Type", photo.getType());
            return new ResponseEntity<>(media, headers,HttpStatus.OK);
        } catch (TriddyPhotoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/api/photos/{id}/title")
    public ResponseEntity<String> getPhotoTitle(@PathVariable String id) {
        try {
            String title = photoService.getPhotoTitle(id);
            return new ResponseEntity<>(title, HttpStatus.OK);
        } catch (TriddyPhotoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/api/photos/{id}")
    public ResponseEntity<String> delPhoto(@PathVariable String id){
        try {
            String title = photoService.delPhoto(id);
            return new ResponseEntity<>(title + " deleted", HttpStatus.OK);
        } catch (TriddyPhotoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        
    }
    
}
