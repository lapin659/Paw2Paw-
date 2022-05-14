package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
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
    @Autowired
    private OrderRepository orderRepository;
    public void addOrder(OrderHistory orderHistory, User user){
        orderHistory.setUser(user);
        orderRepository.save(orderHistory);
    }

    public List<OrderHistory> findUserOrder(User user){
        return orderRepository.findByUser(user);
    }







}
