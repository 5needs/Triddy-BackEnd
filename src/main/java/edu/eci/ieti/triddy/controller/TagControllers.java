package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.services.FilterProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tags")
public class TagControllers {

    @Autowired
    @Qualifier("filterProduct")
    FilterProductService filterProductService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ResponseEntity<?> getAllTags(){
        try {
            return new ResponseEntity<>(filterProductService.getAllTags(),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{keyword}",method = RequestMethod.GET)
    public ResponseEntity<?> getTag(@PathVariable String keyword){
        try {
            return new ResponseEntity<>(filterProductService.getTag(keyword),HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/add/{keyword}",method = RequestMethod.POST)
    public ResponseEntity<?> addNewTag(@PathVariable String keyword){
        try {
            filterProductService.addNewTag(keyword);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{keyword}/subTags/{newRelatedTag}",method = RequestMethod.POST)
    public ResponseEntity<?> addRelatedTag(@PathVariable String keyword, @PathVariable String newRelatedTag){
        try {
            filterProductService.addRelatedTag(keyword,newRelatedTag);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/remove/{keyword}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteTag(@PathVariable String keyword){
        try {
            filterProductService.deleteTag(keyword);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
