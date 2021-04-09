package edu.eci.ieti.triddy.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void editProduct() throws ProductException {
        Product product = new Product(null,"description","nombre");
        productRepository.save(product);
        String[] list = {"img"};
        Product product2 = new Product(list,"description2","nombre2");
        productService.editProduct(product.getId(), product2);
        Product productBD= (Product) productRepository.findAllById(product.getId()).orElseThrow(()->new ProductException("Product not found"));
        assertEquals(product2.getName(),productBD.getName());
    }
    @Test
    void shouldException()  {
        try {
            Product product = new Product(null,"description1","nombre1");
            productRepository.save(product);
            Product product2 = new Product(null,null,null);
            productService.editProduct(product.getId(), product2);
        } catch (ProductException e) {
            assertTrue(true);
        }
    }
}