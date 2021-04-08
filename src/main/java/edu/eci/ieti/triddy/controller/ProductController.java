package edu.eci.ieti.triddy.controller;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/id/{idproduct}")
    public ResponseEntity<?> getProduct(@PathVariable String idproduct){
        try{
            return new ResponseEntity<>(productService.getProduct(idproduct), HttpStatus.ACCEPTED);
        }catch (ProductException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user/{idUser}")
    public ResponseEntity<?> getProductByIdUser(@PathVariable String idUser){
        return new ResponseEntity<>(productService.getProductByIdUser(idUser), HttpStatus.ACCEPTED);
    }
}
