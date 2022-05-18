package com.webapp.paw2paw.service;

import com.webapp.paw2paw.model.OrderHistory;
import com.webapp.paw2paw.model.User;
import com.webapp.paw2paw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class OrderService {

    public List<OrderHistory> getAllOrders(){
        List<OrderHistory> listOfOrders = new ArrayList<>();
        long tempId = 12345;
        User tempUser =  new User();
        listOfOrders.add(new OrderHistory("Cat bed", "for canned food sampler", " ",tempId , tempUser,15));
        listOfOrders.add(new OrderHistory("Dog leash", "for dog toy", " ", tempId, tempUser,10));
        listOfOrders.add(new OrderHistory("1-hr dog walk", "for 2-day cat sitting", " ", tempId, tempUser,20));

        return listOfOrders;
    }


    public OrderHistory getOrderByName(String orderItem) {

        Predicate<OrderHistory> byOrderName = p -> p.getOrderItem().equals(orderItem);
        return filterOrders(byOrderName);
    }

    public OrderHistory filterOrders(Predicate<OrderHistory> strategy) {
        return getAllOrders().stream().filter(strategy).findFirst().orElse(null);
    }


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
