package com.genspark.order_service.Entity;

//public class OrderItem {
//}
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="orderItem")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
