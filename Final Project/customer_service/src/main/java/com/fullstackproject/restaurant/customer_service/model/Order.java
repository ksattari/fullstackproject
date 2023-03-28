package com.fullstackproject.restaurant.customer_service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @Pattern(regexp = "^\\d{10}$",message="Please Enter 10 digits")
    @NotNull(message = "This field can not be empty")
    private String phoneNumber;
    private List<MenuItem> menuItems;
    private Double orderTotal;
    private LocalDateTime orderDate;
    private int orderStatus;
}
