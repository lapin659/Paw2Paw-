package com.webapp.paw2paw.model;

import com.webapp.paw2paw.service.ProductService;

import javax.persistence.*;

@Entity
@Table(name = "orderHistory")
public class OrderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 10)
    private Long orderId;

    @Column(name = "OrderItem", length = 20)
    private String orderItem;

    @Column(name = "OrderPrice", length = 10)
    private double orderPrice;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
    private User user;
    @Column(name = "exchangeItem", length = 30)
    private String exchangeItem;
    @Column(name = "buyerMessage", length = 128)
    private String buyerMessage;



    public OrderHistory(String orderItem, String exchangeItem, String buyerMessage,
                        Long orderId, User user, double orderPrice) {
        this.orderItem = orderItem;
        this.exchangeItem = exchangeItem;
        this.buyerMessage = buyerMessage;
        this.orderId = orderId;
        this.user = user;
        this.orderPrice = orderPrice;


    }


    public OrderHistory(String orderItem, String buyerMessage) {
        this.orderItem = orderItem;
        this.buyerMessage = buyerMessage;
    }

    public OrderHistory(String orderItem) {
        this.orderItem = orderItem;
    }

    public OrderHistory(){
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(String orderItem) {
        this.orderItem = orderItem;
    }

    public String getExchangeItem() {
        return exchangeItem;
    }

    public void setExchangeItem(String exchangeItem) {
        this.exchangeItem = exchangeItem;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }
    public double getOrderPrice() {
        return orderPrice;
    }
    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }



    public OrderHistory getOrderedProduct(String productId){
        ProductService productService = new ProductService();
        OrderHistory currOrderHistory = new OrderHistory();
        currOrderHistory.setOrderItem(productId);
        return currOrderHistory;
    }










}
