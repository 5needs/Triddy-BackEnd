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
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void createProduct() throws ProductException {
        Product product = new Product(null,"description","nombre");
        String string = productService.createProduct(product);
        assertEquals("successfully created", string);
    }

    @Test
    void deleteProductService() throws ProductException {
        Product product = new Product(null,"description","nombre");
        productRepository.save(product);
        productService.deleteProduct(product.getId());
        assertFalse(productRepository.existsById(product.getId()));
    }
    @Test
    void shouldExceptionDeleteProduct()  {
        try {
            Product product = new Product(null,"description1","nombre1");
            productRepository.save(product);
            productService.deleteProduct("id does not exist");
        } catch (ProductException e) {
            assertTrue(true);
        }
    }
}
