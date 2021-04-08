package edu.eci.ieti.triddy.services.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.triddy.model.Discount;
import edu.eci.ieti.triddy.repository.DiscountRepository;
import edu.eci.ieti.triddy.services.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    DiscountRepository discountRepository;
    public List<Discount> getActiveDiscounts(){
        return discountRepository.findByEndAfterAndStartBefore(new Date(), new Date());
    }

    
    public List<Discount> getDiscountOfTheDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        Calendar calendar2 = Calendar.getInstance();
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        return discountRepository.findByEndAfterAndStartBefore(calendar.getTime(), calendar2.getTime());
    }

    public Boolean productHaveActiveDiscount(String product){
        boolean res = false;
        List<Discount> discounts = discountRepository.findByProductAndEndAfterAndStartBefore(product, new Date(), new Date());
        if (!discounts.isEmpty()){
            res = true;
        }
        return res;
    }

    public List<Discount> getProductActiveDiscounts(String product){
        return discountRepository.findByProductAndEndAfterAndStartBefore(product, new Date(), new Date());
    }

    public List<Discount> getDiscountsOfProduct(String product){
        return discountRepository.findByProduct(product);
    }

    public List<Discount> getTypeActiveDiscounts(String type){
        return discountRepository.findByTypeAndEndAfterAndStartBefore(type, new Date(), new Date());
    }

    public Discount addDiscount(Discount discount){
        return discountRepository.save(discount);
    }

}
