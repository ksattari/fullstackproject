package com.genspark.order_service.controller;

import com.genspark.order_service.Entity.MenuItem;
import com.genspark.order_service.Entity.Order;
import com.genspark.order_service.Service.OrderServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Order_Controller {
    @Autowired
    private OrderServiceInt orderService;
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
        return  this.orderService.addItem(menuItem);
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
        return this.orderService.deleteItemById(Long.parseLong(itemId));
    }
    @PostMapping("/saveOrder")
    public Order saveOrder(@RequestBody Order order){
            return orderService.addOrder(order);
    }

    @GetMapping("/orders")
    public List<Order> getOrders(){
        return orderService.getOrders();
    }
    @PostMapping("/orders")
    void addUser(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("/menu")
    public List<MenuItem> getMenuItems(){
        return orderService.getMenuItems();
    }
}
