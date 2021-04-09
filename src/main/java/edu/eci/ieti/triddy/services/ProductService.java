package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;

public interface ProductService {
    void editProduct(String id, Product product) throws ProductException;
}