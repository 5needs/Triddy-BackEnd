package edu.eci.ieti.triddy.persistence;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;

public interface ProductPersistence {
    public String createProduct(Product product) throws ProductException;
}
