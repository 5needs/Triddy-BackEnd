package edu.eci.ieti.triddy.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductTest {

    String[] temp = new String[2];
    Product product = new Product(temp,"...","nameTest");


    @Test
    void getId() {

    }

    @Test
    void setId() {

    }

    @Test
    void getUserId() {
    }

    @Test
    void setUserId() {
    }

    @Test
    void getPictures() {
        assertEquals(temp,product.getPictures());
    }

    @Test
    void setPictures() {
        String[] temp2= new String[5];
        product.setPictures(temp2);
        assertEquals(temp2.length, product.getPictures().length);
    }

    @Test
    void getName() {
        assertEquals("nameTest",product.getName());
    }

    @Test
    void setName() {
        product.setName("namedTest2");
        assertEquals("namedTest2",product.getName());
    }

    @Test
    void getDescription() {
        assertEquals("...",product.getDescription());
    }

    @Test
    void setDescription() {
        product.setDescription("Cambio de test");
        assertEquals("Cambio de test",product.getDescription());
    }

    @Test
    void getAvailable() {
        assertEquals(true,product.getAvailable());
    }

    @Test
    void setAvailable() {
        product.setAvailable(false);
        assertEquals(false,product.getAvailable());
    }
}