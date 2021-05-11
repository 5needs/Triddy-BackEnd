package edu.eci.ieti.triddy.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.triddy.model.Discount;
import edu.eci.ieti.triddy.services.DiscountService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/discount")
public class DiscountController {

    @Autowired
    DiscountService discountService;

    @PostMapping()
    public ResponseEntity<Discount> addDiscount(@RequestBody Discount discount){
        Discount newDiscount = discountService.addDiscount(discount);
        return new ResponseEntity<>(newDiscount, HttpStatus.ACCEPTED);
    }

    @GetMapping("/active")
    public ResponseEntity<List<Discount>> getActiveDiscounts(){
        List<Discount> discounts = discountService.getActiveDiscounts();
        return new ResponseEntity<>(discounts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/today")
    public ResponseEntity<List<Discount>> getDiscountOfTheDay(){
        List<Discount> discounts = discountService.getDiscountOfTheDay();
        return new ResponseEntity<>(discounts, HttpStatus.ACCEPTED);
    }
    
    @GetMapping("/productHave/{productId}")
    public ResponseEntity<Boolean> productHaveActiveDiscount(@PathVariable String productId){
        Boolean res = discountService.productHaveActiveDiscount(productId);
        return new ResponseEntity<>(res, HttpStatus.ACCEPTED); 
    }

    @GetMapping("/product/active/{productId}")
    public ResponseEntity<List<Discount>> getProductActiveDiscounts(@PathVariable String productId){
        List<Discount> discounts = discountService.getProductActiveDiscounts(productId);
        return new ResponseEntity<>(discounts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/all/{productId}")
    public ResponseEntity<List<Discount>> getDiscountsOfProduct(@PathVariable String productId){
        List<Discount> discounts = discountService.getDiscountsOfProduct(productId);
        return new ResponseEntity<>(discounts, HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/type/{type}")
    public ResponseEntity<List<Discount>> getTypeActiveDiscounts(@PathVariable String type){
        List<Discount> discounts = discountService.getTypeActiveDiscounts(type);
        return new ResponseEntity<>(discounts, HttpStatus.ACCEPTED);
    }

    
}
