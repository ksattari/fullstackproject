package com.genspark.order_service.Service;

import com.genspark.order_service.Entity.MenuItem;
import com.genspark.order_service.Entity.Order;
import com.genspark.order_service.Entity.OrderItem;

import java.util.List;

public interface OrderServiceInt {
    Order addOrder(Order order);
   // OrderItem addOrderItem(OrderItem orderItem);
   // List<Order> getAllOrder();
    //List<MenuItem> getItems();
    MenuItem addItem(MenuItem menuItem);
    String deleteItemById(long itemId);

    List<Order> getOrders();

    List<MenuItem> getMenuItems();

    void save(Order order);

    void deleteOrder(long parseLong);
}
