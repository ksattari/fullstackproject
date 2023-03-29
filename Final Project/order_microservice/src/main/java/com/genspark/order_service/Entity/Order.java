package com.genspark.order_service.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="restaurantOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;
    private String customerName;
    private String address;
    private String phoneNumber;
    //private List<MenuItem> menuItems;

   @OneToMany
   private List<OrderItem> orderItems;

    private Double orderTotal;
    private LocalDateTime orderDate;
    private int orderStatus;




        public void setOrderItems(List<OrderItem> orderItems){

            this.orderItems = orderItems;
            this.orderTotal = orderItems.stream()
                    .map( o -> o.getTotalCost() )
                    .reduce(0.0, Double::sum);
        }

}

