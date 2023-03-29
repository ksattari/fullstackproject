package com.genspark.order_service.controller;

import com.genspark.order_service.Entity.MenuItem;
import com.genspark.order_service.Service.OrderServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Order_Controller {
    @Autowired
    private OrderServiceInt orderServiceInt;
   // @GetMapping("/orders")
    //public List<Order> getOrders()
    //{
    //return this.orderServiceInt.getAllOrder();
    //}
    //@GetMapping("/items")
    //public List<MenuItem> getItems(){
      //  return this.orderServiceInt.getItems();
    //}
    @PostMapping("/addItem")
    public MenuItem addItem(@RequestBody MenuItem menuItem)
    {
        return  this.orderServiceInt.addItem(menuItem);
    }
    //@PostMapping("/addOrderItem")
    //public OrderItem addorderItem(@RequestBody OrderItem orderitem)
    //{
      //  return  this.orderServiceInt.addOrderItem(orderitem);
    //}
    //@PostMapping("/addOrder")
    //public Order addOrder(@RequestBody Order order)
    //{
      //  return  this.orderServiceInt.addOrder(order);
    //}
    @DeleteMapping("/items/{itemId}")
    public String deleteItem(@PathVariable String itemId)
    {
        return this.orderServiceInt.deleteItemById(Long.parseLong(itemId));
    }
}
