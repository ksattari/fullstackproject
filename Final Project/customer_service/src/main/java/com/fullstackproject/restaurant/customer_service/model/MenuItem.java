package com.fullstackproject.restaurant.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuItem {

    private long itemId;
    private String itemName;
    private double itemPrice;
}
