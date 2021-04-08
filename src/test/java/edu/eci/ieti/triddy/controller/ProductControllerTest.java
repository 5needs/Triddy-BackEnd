package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import edu.eci.ieti.triddy.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductController productController;

    @AfterEach
    public void productRestart(){
        productRepository.deleteAll();
    }

    @Test
    public void getProduct(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        productRepository.save(product);
        ResponseEntity<?> responseEntity = productController.getProduct(product.getId());
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }

    @Test
    public void getProductFailed(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        ResponseEntity<?> responseEntity = productController.getProduct(product.getId());
        assertEquals(HttpStatus.NOT_FOUND,responseEntity.getStatusCode());
    }

    @Test
    public void getProductByIdUser(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        productRepository.save(product);
        ResponseEntity<?> responseEntity = productController.getProductByIdUser(product.getUserId());
        assertEquals(HttpStatus.ACCEPTED,responseEntity.getStatusCode());
    }


}