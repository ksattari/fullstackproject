package com.fullstackproject.restaurant.customer_service.controller;

import com.fullstackproject.restaurant.customer_service.model.MenuItem;
import com.fullstackproject.restaurant.customer_service.model.Order;
import com.fullstackproject.restaurant.customer_service.model.OrderItem;
import com.fullstackproject.restaurant.customer_service.util.OrderStatus;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class OrderController implements WebMvcConfigurer {

    @Autowired
    List<MenuItem> menu;

    @GetMapping("/")
    public String orderPage(Order order, Model model, WebRequest w){
        log.info("INSIDE orderPage METHOD");
        model.addAttribute("theDate", new SimpleDateFormat("MM/dd/yyyy")
                .format(new Date()));
        model.addAttribute("theMenu",menu);

        return "order";
    }

   @PostMapping("/processOrder")
    public String processOrder(@Valid Order order, BindingResult bindingResult, WebRequest w, Model model){

       model.addAttribute("theDate", new SimpleDateFormat("MM/dd/yyyy")
               .format(new Date()));
       model.addAttribute("theMenu",menu);
       model.addAttribute("theOrder",order);

       if (bindingResult.hasErrors()) {
           return "order";
       }

       //add menu items ordered to order
       List<OrderItem> orderItems = new ArrayList<>();
       for(MenuItem i : menu ){
            String sQty = w.getParameter(i.getItemName());
           long lQty = 0;
            try {
                 lQty = Integer.parseInt(sQty);
            }
            catch(NumberFormatException e){
                log.info(e.getMessage());
                lQty = 0;
           }
            if(lQty > 0){
                    log.info("VALUE OF dQTy is " + lQty);
                    orderItems.add(new OrderItem(i.getItemName(),i.getItemPrice(),lQty));
                }
       }

       if(orderItems.isEmpty()){
           return "order";
       }

           order.setOrderItems(orderItems);
           order.setOrderDate(new java.util.Date().toInstant()
                   .atZone(ZoneId.systemDefault())
                   .toLocalDateTime());
           order.setOrderId(1245);
           order.setOrderStatus(OrderStatus.NEW);
           log.info(order.toString());

       return  "confirmation";
    }



    @InitBinder
    public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
    }
}
