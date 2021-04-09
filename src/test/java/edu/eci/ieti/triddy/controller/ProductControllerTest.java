package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;
    @Autowired
    ProductRepository productRepository;
    @Test
    void deleteProductTest() throws ProductException {
        Product product = new Product(null,"description","nombre");
        ResponseEntity<String> response = productController.deleteProduct(product.getId());
        assertFalse(productRepository.existsById(product.getId()));
    }
    @Test
    void shouldException() {
        ResponseEntity<String> response = productController.deleteProduct("id does not exist");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}