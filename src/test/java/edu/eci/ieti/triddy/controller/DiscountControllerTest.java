package edu.eci.ieti.triddy.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import edu.eci.ieti.triddy.model.Discount;

@SpringBootTest
class DiscountControllerTest {

    @Autowired
    DiscountController discountController;

    @Test
    void findActiveProducts(){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 10);
        Discount discount = new Discount("product", calendar.getTime(), calendar2.getTime(), "type");
        discountController.addDiscount(discount);
        discount = new Discount("product", calendar.getTime(), calendar2.getTime(), "type");
        discountController.addDiscount(discount);
        discount = new Discount("product", calendar2.getTime(), calendar.getTime(), "type");
        discountController.addDiscount(discount);
        ResponseEntity<?> resp= discountController.getActiveDiscounts();
        List<?> discounts = (List<?>) resp.getBody();
        assertTrue(2 <= discounts.size());
        resp= discountController.getDiscountOfTheDay();
        discounts = (List<?>) resp.getBody();
        assertTrue(2 <= discounts.size());
    }

    @Test 
    void findProductDiscount(){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 10);
        Discount discount = new Discount("product1", calendar.getTime(), calendar2.getTime(), "type");
        discountController.addDiscount(discount);
        discount = new Discount("product1", calendar.getTime(), calendar2.getTime(), "type");
        discountController.addDiscount(discount);
        discount = new Discount("product1", calendar2.getTime(), calendar.getTime(), "type");
        discountController.addDiscount(discount);
        ResponseEntity<?> resp= discountController.getDiscountsOfProduct("product1");
        List<?> discounts = (List<?>) resp.getBody();
        assertEquals(3, discounts.size());
        resp= discountController.productHaveActiveDiscount("product1");
        Boolean have = (Boolean) resp.getBody();
        assertTrue(have);
        resp= discountController.getProductActiveDiscounts("product1");
        discounts = (List<?>) resp.getBody();
        assertEquals(2, discounts.size());
    }

    @Test
    void findTypeDiscount(){
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DATE, 10);
        Discount discount = new Discount("product2", calendar.getTime(), calendar2.getTime(), "type2");
        discountController.addDiscount(discount);
        discount = new Discount("product2", calendar.getTime(), calendar2.getTime(), "type2");
        discountController.addDiscount(discount);
        discount = new Discount("product2", calendar2.getTime(), calendar.getTime(), "type2");
        discountController.addDiscount(discount);
        ResponseEntity<?> resp= discountController.getTypeActiveDiscounts("type2");
        List<?> discounts = (List<?>) resp.getBody();
        assertEquals(2, discounts.size());
    }
    
}
