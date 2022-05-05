package com.webapp.paw2paw.model;

import org.springframework.stereotype.Component;

@Component
public class OrderHistory {


    private String orderItem;
    private String exchangeItem;
    private String buyerMessage;

    public OrderHistory(String orderItem, String exchangeItem, String buyerMessage) {
        this.orderItem = orderItem;
        this.exchangeItem = exchangeItem;
        this.buyerMessage = buyerMessage;
    }

    public OrderHistory(){

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
