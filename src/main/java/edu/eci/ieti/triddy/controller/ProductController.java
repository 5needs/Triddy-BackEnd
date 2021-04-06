package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping(value = "/create")
    public ResponseEntity<?> createProduct(@RequestBody Product product) throws ProductException {
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.CREATED);
    }
}