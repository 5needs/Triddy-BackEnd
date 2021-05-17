package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import edu.eci.ieti.triddy.services.ProductService;
import org.junit.jupiter.api.AfterEach;
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
    void shouldExceptionProductEdit() {
        Product product = new Product(null,"description","nombre");
        String[] list = {"img"};
        Product product2 = new Product(list,null,null);
        ResponseEntity<String> response = productController.editProduct(product2,product.getId());
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void deleteProductTest() throws ProductException {
        Product product = new Product(null,"description","nombre");
        ResponseEntity<String> response = productController.deleteProduct(product.getId());
        assertFalse(productRepository.existsById(product.getId()));
    }
    @Test
    void shouldExceptionProductTest() {
        ResponseEntity<String> response = productController.deleteProduct("id does not exist");
        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

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
