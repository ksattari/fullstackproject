package com.fullstackproject.restaurant.customer_service.model;

import ch.qos.logback.core.joran.sanity.Pair;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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

    @NotNull(message = "This field can not be empty")
    private String customerName;

    @NotNull(message = "This field can not be empty")
    private String address;

    @Pattern(regexp = "^\\d{10}$",message="Please Enter 10 digits")
    @NotNull(message = "This field can not be empty")
    private String phoneNumber;
    private List<OrderItem> orderItems;
    private double orderTotal;
    private LocalDateTime orderDate;
    private int orderStatus;

    public void setOrderItems(List<OrderItem> orderItems){

        this.orderItems = orderItems;
        this.orderTotal = orderItems.stream()
                  .map( o -> o.getTotalCost() )
                 .reduce(0.0, Double::sum);
    }


}
