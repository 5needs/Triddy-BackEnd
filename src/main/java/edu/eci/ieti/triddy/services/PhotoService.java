package edu.eci.ieti.triddy.services;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.model.Photo;

public interface PhotoService {
    
    List<Photo> getPhotos();
    String addPhoto(String owner, MultipartFile file) throws IOException;
    Photo getPhoto(String id);
    void delPhoto(String id);
}
