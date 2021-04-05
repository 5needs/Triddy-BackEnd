package edu.eci.ieti.triddy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.services.PhotoService;

@RestController
@RequestMapping("/api/photos")
public class PhotoController {

    @Autowired
    PhotoService photoService;

    @GetMapping
    public List<Photo> getPhotos(){
        return photoService.getPhotos();
    }

    @PostMapping
    public String addPhoto(@RequestParam("title") String title, @RequestParam("image") MultipartFile image) throws IOException {
        String id = photoService.addPhoto(title, image);
        return id;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPhotoImage(@PathVariable String id) {
        Photo photo = photoService.getPhoto(id);
        HttpHeaders headers = new HttpHeaders();
        byte[] media = photo.getImage().getData();
        headers.add("Content-Type", "image/png");
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers,HttpStatus.OK);

        return responseEntity;
    }
    @GetMapping("/{id}/title")
    public ResponseEntity<String> getPhotoTitle(@PathVariable String id) {
        Photo photo = photoService.getPhoto(id);
        String title = photo.getTitle();

        return new ResponseEntity<>(title ,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delPhoto(@PathVariable String id){
        Photo photo = photoService.getPhoto(id);
        String title = photo.getTitle();
        photoService.delPhoto(id);
        
        return new ResponseEntity<>(title + " deleted", HttpStatus.OK);
    }
    
}
