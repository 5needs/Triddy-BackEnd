package edu.eci.ieti.triddy.services.Impl;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;
import edu.eci.ieti.triddy.repository.ProductRepository;
import edu.eci.ieti.triddy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

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
