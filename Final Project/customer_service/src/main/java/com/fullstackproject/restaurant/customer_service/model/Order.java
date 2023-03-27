package com.fullstackproject.restaurant.customer_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    private List<MenuItem> menuItems;
    private Double orderTotal;
    private LocalDateTime orderDate;
    private int orderStatus;
}
