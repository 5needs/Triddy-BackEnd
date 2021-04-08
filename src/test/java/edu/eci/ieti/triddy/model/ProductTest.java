package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProductTest {
    @Test
    void createProduct() {
        Product product = new Product(null,"description","nombre");
        assertEquals("nombre",product.getName());
        assertEquals("description", product.getDescription());
        assertEquals(null, product.getPictures());
        assertEquals(true, product.getAvailable());
    }

    @Test
    void ProductSetMethod() {
        Product product = new Product(null,"description","nombre");
        product.setAvailable(false);
        assertEquals(false, product.getAvailable());

        product.setDescription("description2");
        assertEquals("description2", product.getDescription());

        product.setName("nombre2");
        assertEquals("nombre2",product.getName());

        String[] list = {"hola"};
        product.setPictures(list);
        assertEquals(list, product.getPictures());
    }
}
