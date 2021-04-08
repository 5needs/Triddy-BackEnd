package edu.eci.ieti.triddy.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DiscountTest {

    @Test
    void testCreator(){
        Date d = new Date();
        Discount discount = new Discount("product", d, d, "type");
        String s = String.format("Discount[ product= '%s', type= '%s', start= '%s', end= '%s']"  
                ,"product","type",d,d);
        assertEquals(s, discount.toString());
    }

    @Test
    void testSetter(){
        Date d = new Date();
        Discount discount = new Discount();
        discount.setProduct("product");
        assertEquals("product", discount.getProduct());
        discount.setType("type");
        assertEquals("type", discount.getType());
        discount.setEnd(d);
        assertEquals(d, discount.getEnd());
        discount.setStart(d);
        assertEquals(d, discount.getStart());
    }
    
}
