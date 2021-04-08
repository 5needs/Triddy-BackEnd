package edu.eci.ieti.triddy.services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    void createProduct() throws ProductException {
        Product product = new Product(null,"description","nombre");
        String string = productService.createProduct(product);
        assertEquals("successfully created", string);
    }
}
