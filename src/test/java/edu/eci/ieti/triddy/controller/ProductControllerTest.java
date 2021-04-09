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

@SpringBootTest
class ProductControllerTest {
    @Autowired
    ProductController productController;
    @Autowired
    ProductRepository productRepository;
    @Test
    void putProductEdit() throws ProductException {
        Product product = new Product(null,"description","nombre");
        productRepository.save(product);
        String[] list = {"img"};
        Product product2 = new Product(list,"description2","nombre2");
        ResponseEntity<String> response = productController.editProduct(product2, product.getId());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    @Test
    void shouldException() {
        Product product = new Product(null,"description","nombre");
        String[] list = {"img"};
        Product product2 = new Product(list,null,null);
        ResponseEntity<String> response = productController.editProduct(product2,product.getId());
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }
}