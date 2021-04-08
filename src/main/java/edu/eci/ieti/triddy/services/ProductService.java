package edu.eci.ieti.triddy.services;

import edu.eci.ieti.triddy.exceptions.ProductException;
import edu.eci.ieti.triddy.model.Product;

import java.util.List;

public interface ProductService {

    Product getProduct(String idProduct) throws ProductException;

    List<Product> getProductByIdUser(String idUser);

}
