package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;

public interface ProductService {
    String createProduct(Product product) throws ProductException;
}