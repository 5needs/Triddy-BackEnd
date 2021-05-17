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
    public ResponseEntity<String> createProduct(@RequestBody Product product) {
        try {
            String response = productService.createProduct(product);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<String> editProduct(@RequestBody Product product, @PathVariable  String id) {
        try {
            productService.editProduct(id,product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable  String id) {
        try {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProductException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }


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
