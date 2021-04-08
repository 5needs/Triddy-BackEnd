package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @AfterEach
    public void productRestart(){
        productRepository.deleteAll();
    }

    @Test
    public void getProduct(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        productRepository.save(product);
        try {
            assertNotEquals(null,productService.getProduct(product.getId()));
        } catch (ProductException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductFailed(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        String tempId = product.getId();
        try {
            productService.getProduct(product.getId());
        } catch (ProductException e) {
            assertEquals(true, productRepository.findAll().isEmpty());
        }
    }

    @Test
    public void getProductByIdUser(){
        String[] temp = new String[2];
        Product product = new Product(temp,"...","nameTest");
        productRepository.save(product);
        String tempId = product.getUserId();
        assertEquals(false,productService.getProductByIdUser(tempId).isEmpty());
    }

}