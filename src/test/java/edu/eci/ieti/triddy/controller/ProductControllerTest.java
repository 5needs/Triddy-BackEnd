package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;
    @Test
    void postProductCreate() throws ProductException {
        Product product = new Product(null,"description","nombre");
        ResponseEntity<String> response = productController.createProduct(product);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    @Test
    void shouldException() {
        Product product = new Product(null,null,"nombre");
        ResponseEntity<String> response = productController.createProduct(product);
        assertEquals(HttpStatus.NOT_ACCEPTABLE, response.getStatusCode());
    }
}
