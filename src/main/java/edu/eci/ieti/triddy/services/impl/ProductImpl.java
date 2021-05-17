package edu.eci.ieti.triddy.services.impl;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import edu.eci.ieti.triddy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public String createProduct(Product product) throws ProductException {

        if(product.getName() == null || product.getDescription() == null) {
           throw new ProductException("There was an error creating the product");
        }
        productRepository.save(product);
        return "successfully created";
    }
    
    public void editProduct(String id, Product product) throws ProductException {
        if (product.getName() == null || product.getDescription() == null) {
            throw new ProductException("values cannot be null");
        } else {
            Product productBD= (Product) productRepository.findAllById(id).orElseThrow(()->new ProductException("Product not found"));
            productBD.setPictures(product.getPictures());
            productBD.setName(product.getName());
            productBD.setDescription(product.getDescription());
            productBD.setAvailable(product.getAvailable());
            productRepository.save(productBD);
        }
    }

    public void deleteProduct(String id) throws ProductException {
        if(productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new ProductException("Product not found");
        }
    }

    @Override
    public Product getProduct(String idProduct) throws ProductException {
        Product product = productRepository.findProductById(idProduct);
        if (product == null){
            throw  new ProductException("Product Not Found");
        }
        return product;
    }

    @Override
    public List<Product> getProductByIdUser(String idUser) {
        List<Product> products = productRepository.findByUserId(idUser);
        return products;
    }
}
