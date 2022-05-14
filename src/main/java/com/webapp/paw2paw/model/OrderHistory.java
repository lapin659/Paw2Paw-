package com.webapp.paw2paw.model;

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
    @Column(name = "CustomerName", length = 20)
    private String customerName;
    @Column(name = "exchangeItem", length = 30)
    private String exchangeItem;
    @Column(name = "buyerMessage", length = 128)
    private String buyerMessage;

    public OrderHistory(String orderItem, String exchangeItem, String buyerMessage, Long orderId, String customerName) {
        this.orderItem = orderItem;
        this.exchangeItem = exchangeItem;
        this.buyerMessage = buyerMessage;
        this.orderId = orderId;
        this.customerName = customerName;
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


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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











}
