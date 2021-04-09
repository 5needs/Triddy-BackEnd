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

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<String> editProduct(@RequestBody Product product, @PathVariable  String id) {
        try {
            productService.editProduct(id,product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}