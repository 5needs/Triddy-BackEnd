package edu.eci.ieti.triddy.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.repository.PhotoRepository;
import edu.eci.ieti.triddy.services.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    public List<Photo> getPhotos(){
        List<Photo> photos = new ArrayList<Photo>();
        for (Photo photo : photoRepository.findAll()){
            photo.setImage(null);
            photos.add(photo);
        }
        return photos;
    }

    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepository.insert(photo); 
        return photo.getId(); 
    }

    public Photo getPhoto(String id) { 
        if(photoRepository.findById(id).isPresent()){
            return photoRepository.findById(id).get();
        }
        return null; 
    }

    @Override
    public void delPhoto(String id) {
        photoRepository.deleteById(id);
    }
}