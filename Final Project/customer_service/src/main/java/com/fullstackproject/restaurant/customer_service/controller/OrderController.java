package com.fullstackproject.restaurant.customer_service.controller;

import com.fullstackproject.restaurant.customer_service.model.MenuItem;
import com.fullstackproject.restaurant.customer_service.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Controller
@Slf4j
public class OrderController implements WebMvcConfigurer {

    @Autowired
    List<MenuItem> menu;

    @GetMapping("/")
    public String orderPage(Model model, WebRequest w){
        log.info("INSIDE orderPage METHOD");
        model.addAttribute("theDate", new SimpleDateFormat("MM/dd/yyyy")
                .format(new Date()));
        model.addAttribute("theMenu",menu);

        return "order";
    }

   @PostMapping("/processOrder")
    public String processOrder(Order order, WebRequest w, Model model){

        log.info(order.toString());
        return "confirmation";
    }
}
