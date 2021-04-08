package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.ProductTag;
import edu.eci.ieti.triddy.repository.TagRepository;
import edu.eci.ieti.triddy.services.FilterProductService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

@SpringBootTest
public class TagControllersTest {

    @Autowired
    TagControllers tagControllers;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    @Qualifier("filterProduct")
    FilterProductService filterProductService;

    @AfterEach
    public void TagRestart(){
        tagRepository.deleteAll();
    }

    @Test
    public void getAllTags(){
        assertNotEquals(null,tagControllers.getAllTags());
    }

    @Test
    public void getTag(){
        ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
        tagRepository.save(productTag);
        ResponseEntity<?> responseEntity = tagControllers.getTag("Test1tag");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void getTagFalied(){
        ResponseEntity<?> responseEntity = tagControllers.getTag("Test1tag");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void addNewTag(){
        ResponseEntity<?> responseEntity = tagControllers.addNewTag("Test1tag");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void addNewTagFalied(){
        ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
        tagRepository.save(productTag);
        ResponseEntity<?> responseEntity = tagControllers.addNewTag("Test1tag");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void addRelatedTag(){
        ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
        ProductTag productTag1 = new ProductTag("Test2tag",new ArrayList<>());
        tagRepository.save(productTag);
        tagRepository.save(productTag1);
        ResponseEntity<?> responseEntity = tagControllers.addRelatedTag("Test1tag","Test2tag");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void addRelatedTagFailedRelated(){
        ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
        tagRepository.save(productTag);
        ResponseEntity<?> responseEntity = tagControllers.addRelatedTag("Test1tag","Test2tag");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void deleteTag(){
        ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
        tagRepository.save(productTag);
        ResponseEntity<?> responseEntity = tagControllers.deleteTag("Test1tag");
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void deleteTagFalied(){
        ResponseEntity<?> responseEntity = tagControllers.deleteTag("Test1tag");
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }
}
