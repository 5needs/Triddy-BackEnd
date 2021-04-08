package edu.eci.ieti.triddy.services;

import java.util.List;

import edu.eci.ieti.triddy.model.Discount;

public interface DiscountService {
    List<Discount> getActiveDiscounts();

    List<Discount> getDiscountOfTheDay();
    
    Boolean productHaveActiveDiscount(String product);

    List<Discount> getProductActiveDiscounts(String product);

    List<Discount> getDiscountsOfProduct(String product);

    List<Discount> getTypeActiveDiscounts(String type);

    Discount addDiscount(Discount discount);
    
}
