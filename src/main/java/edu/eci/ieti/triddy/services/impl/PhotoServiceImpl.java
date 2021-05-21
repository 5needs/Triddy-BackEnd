package edu.eci.ieti.triddy.services.Impl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.bson.BsonBinarySubType;
import org.bson.Document;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.eci.ieti.triddy.exceptions.TriddyPhotoException;
import edu.eci.ieti.triddy.model.Photo;
import edu.eci.ieti.triddy.repository.PhotoRepository;
import edu.eci.ieti.triddy.services.PhotoService;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> getPhotos(){
        return photoRepository.findExcludeImage();
    }

    @Override
    public String addPhoto(String title, MultipartFile file) throws IOException { 
        Photo photo = new Photo(title); 
        photo.setImage(new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo.setType(file.getContentType());
        photo = photoRepository.insert(photo); 
        
        return photo.getId(); 
    }

    @Override
    public Photo getPhoto(String id) throws TriddyPhotoException { 
        Optional<Photo> photo = photoRepository.findById(id);
        if(photo.isPresent()){
            return photo.get();
        }else{
            throw new TriddyPhotoException("Photo not found");
        } 
    }

    @Override
    public String delPhoto(String id) throws TriddyPhotoException {
        String res = getPhotoTitle(id);
        photoRepository.deleteById(id);
        return res;
    }

    @Override
    public String getPhotoTitle(String id) throws TriddyPhotoException {
        String res = photoRepository.findTitleById(id);
        if (res != null){
            Document doc = Document.parse(res);
            photoRepository.deleteById(id);
            return doc.get("title").toString();
        }else{
            throw new TriddyPhotoException("Photo not found");
        }
        
    }
}