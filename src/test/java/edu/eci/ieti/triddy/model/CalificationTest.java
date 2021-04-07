package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalificationTest {

    @Test
    void testConstructor(){
        Calification calification = new Calification("user1", "product", 2.5, 2.5, "comment", "user2", 2.5, "coment");
        String s = String.format("Calification[ qualifier= '%s', product= '%s', productStatus= '%s', productCharacteristics= '%s', productComment= '%s', user= '%s', userCalification= '%s', userComment= '%s' ]"  
        ,"user1", "product", 2.5, 2.5, "comment", "user2", 2.5, "coment");
        assertEquals(s, calification.toString());
    }

    @Test
    void setsTest(){
        Calification calification = new Calification();
        calification.setQualifier("user1");
        assertEquals("user1", calification.getQualifier());
        calification.setProduct("product");
        assertEquals("product", calification.getProduct());
        calification.setProductStatus(2.5);
        assertEquals(2.5, calification.getProducttatus());
        calification.setProductCharacteristics(2.5);
        assertEquals(2.5, calification.getProductCharacteristics());
        calification.setProductComment("comment");
        assertEquals("comment", calification.getProductComment());
        calification.setUser("user2");
        assertEquals("user2", calification.getUser());
        calification.setUserCalification(2.5);
        assertEquals(2.5, calification.getUserCalification());
        calification.setUserComment("comment");
        assertEquals("comment", calification.getUserComment());
    }


    
}
