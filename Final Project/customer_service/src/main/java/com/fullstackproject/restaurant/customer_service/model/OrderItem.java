package com.fullstackproject.restaurant.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {

    private long orderItemId;
    private String orderItemName;
    private double orderItemPrice;
    private long quantity;
    private double totalCost;

    public OrderItem(String orderItemName,Double orderItemPrice, long quantity){
        this.orderItemName= orderItemName;
        this.quantity = quantity;
        this.orderItemPrice = orderItemPrice;
        this.totalCost = this.orderItemPrice * this.quantity;
    }
}
