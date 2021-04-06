package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import edu.eci.ieti.triddy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public String createProduct(Product product) throws ProductException {
        if(productRepository.existsById(product.getId())) {
           throw new ProductException(ProductException.CREATE_PRODUCT_ERROR);
        }
        productRepository.save(product);
        return "successfully created";
    }
}
