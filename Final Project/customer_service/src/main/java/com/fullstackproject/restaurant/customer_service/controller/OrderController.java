package com.fullstackproject.restaurant.customer_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
public class OrderController {

    @GetMapping("/")
    public String orderPage(Model model){
        log.info("INSIDE orderPage METHOD");
        model.addAttribute("theDate",new java.util.Date());
        return "order";
    }
}
