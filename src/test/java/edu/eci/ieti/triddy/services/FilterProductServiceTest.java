package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.TriddyServiceException;
import edu.eci.ieti.triddy.model.ProductTag;
import edu.eci.ieti.triddy.repository.TagRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class FilterProductServiceTest {

    @Autowired
    @Qualifier("filterProduct")
    FilterProductService filterProductService;

    @Autowired
    TagRepository tagRepository;

    @AfterEach
    public void TagRestart(){
        tagRepository.deleteAll();
    }

    @Test
    public void createNewTag(){
        try {
            filterProductService.addNewTag("Test1Tag");
            assertNotEquals(null,tagRepository.findByKeyword("Test1Tag"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createNewTagFail(){
        try {
            ProductTag productTag = new ProductTag("Test2tag",new ArrayList<>());
            tagRepository.save(productTag);
            filterProductService.addNewTag("Test2tag");
        } catch (TriddyServiceException e) {
            assertNotEquals(null,tagRepository.findByKeyword("Test2tag"));
        }
    }

    @Test
    public void getAllTags(){
        assertEquals(tagRepository.findAll(),filterProductService.getAllTags());
    }

    @Test
    public void getTag(){
        try {
            ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
            tagRepository.save(productTag);
            assertNotEquals(null,filterProductService.getTag("Test1Tag"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTagFailed(){
        try {
            filterProductService.getTag("Test2tag");
        } catch (TriddyServiceException e) {
            assertEquals(null,tagRepository.findByKeyword("Test2tag"));
        }
    }

    @Test
    public void addRelatedTag(){
        try {
            ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
            ProductTag productTag1 = new ProductTag("Test2tag",new ArrayList<>());
            tagRepository.save(productTag);
            tagRepository.save(productTag1);
            filterProductService.addRelatedTag("Test1tag","Test2tag");
            assertEquals(false,tagRepository.findByKeyword("Test1tag").getRelatedTags().isEmpty());
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addRelatedTagFailedRelated(){
        try {
            ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
            tagRepository.save(productTag);
            filterProductService.addRelatedTag("Test1tag","Test2tag");
        } catch (TriddyServiceException e) {
            assertEquals(true,tagRepository.findByKeyword("Test1tag").getRelatedTags().isEmpty());
        }
    }

    @Test
    public void addRelatedTagFailedTag(){
        try {
            ProductTag productTag = new ProductTag("Test2tag",new ArrayList<>());
            tagRepository.save(productTag);
            filterProductService.addRelatedTag("Test1tag","Test2tag");
        } catch (TriddyServiceException e) {
            assertEquals(true,tagRepository.findByKeyword("Test2tag").getRelatedTags().isEmpty());
        }
    }

    @Test
    public void addRelatedTagFailedSubTags(){
        try {
            ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
            ProductTag productTag1 = new ProductTag("Test2tag",new ArrayList<>());
            tagRepository.save(productTag);
            tagRepository.save(productTag1);
            filterProductService.addRelatedTag("Test1tag","Test2tag");
            filterProductService.addRelatedTag("Test1tag","Test2tag");
        } catch (TriddyServiceException e) {
            assertEquals(false,tagRepository.findByKeyword("Test1tag").getRelatedTags().isEmpty());
        }
    }

    @Test
    public void deleteTag(){
        try {
            ProductTag productTag = new ProductTag("Test1tag",new ArrayList<>());
            tagRepository.save(productTag);
            filterProductService.deleteTag("Test1Tag");
            assertEquals(null,tagRepository.findByKeyword("Test1Tag"));
        } catch (TriddyServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTagFailed(){
        try {
            filterProductService.deleteTag("Test1Tag");
        } catch (TriddyServiceException e) {
            assertEquals(null,tagRepository.findByKeyword("Test1tag"));
        }
    }
}
