package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.persistence.ProductPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductPersistence productPersistence;
    public String createProduct(Product product) throws ProductException {
        return productPersistence.createProduct(product);
    }
}