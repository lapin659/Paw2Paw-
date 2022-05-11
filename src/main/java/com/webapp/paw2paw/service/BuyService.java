package com.webapp.paw2paw.service;

import org.springframework.stereotype.Service;

@Service
public class BuyService {
    /**
    public List<Product> getAllProducts(){
        List<Product> listOfProducts = new ArrayList<>();
        listOfProducts.add(new Product("123", "Cat bed", "for canned food sampler ", 15, "Cat person A"));
        listOfProducts.add(new Product("124", "Dog leash", "for dog toy ", 10, "Dog person B"));
        listOfProducts.add(new Product("125", "1-hr dog walk", "for 2-day cat sitting ", 20, "Pet person C"));

        return listOfProducts;
    }
    public OrderHistory getBuyByName(String orderItem) {

        Predicate<OrderHistory> byItem = p -> p.getOrderItem().equals(orderItem);
        return byItem;
    }

    public OrderHistory filterProducts(Predicate<OrderHistory> strategy) {
        return getAllProducts().stream().filter(strategy).findFirst().orElse(null);
    }

**/




}
