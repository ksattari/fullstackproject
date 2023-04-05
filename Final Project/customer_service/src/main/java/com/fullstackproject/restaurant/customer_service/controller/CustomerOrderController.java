package com.fullstackproject.restaurant.customer_service.controller;

import com.fullstackproject.restaurant.customer_service.daoservice.CustomerService;
import com.fullstackproject.restaurant.customer_service.model.Login;
import com.fullstackproject.restaurant.customer_service.model.MenuItem;
import com.fullstackproject.restaurant.customer_service.model.Order;
import com.fullstackproject.restaurant.customer_service.model.OrderItem;
import com.fullstackproject.restaurant.customer_service.util.OrderStatus;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Controller
@Slf4j
public class CustomerOrderController implements WebMvcConfigurer {

    List<MenuItem> menu;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CustomerService customerService;



    @PostConstruct
    public void init()
    {

        try {
            ResponseEntity<MenuItem[]> response =
                    restTemplate.getForEntity("http://localhost:8085/menu",MenuItem[].class);
            menu = Arrays.asList(response.getBody());
        }
        catch(RestClientException e){
            log.info(e.getMessage());
        }
    }

    @GetMapping("/order")
    public String orderPage(Order order, Model model){
        //log.info("INSIDE orderPage METHOD");
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
            }
            if(lQty > 0){
                   // log.info("VALUE OF dQTy is " + lQty);
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

        // **********    THIS IS WHERE YOU CALL THE ORDER_MICROSERVICE SAVE RECORD API **********  //
       HttpEntity<Order> request = new HttpEntity<>(order);
       Order confirmationOrder = null;
       try {
           confirmationOrder = restTemplate.postForObject("http://localhost:8085/saveOrder", request, Order.class);
       }
       catch(RestClientException e){
           log.info(e.getMessage());
       }

       model.addAttribute("theOrder",confirmationOrder);

       return  "confirmation";
    }




    @InitBinder
    public void initialBinderForTrimmingSpaces(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimEditor);
    }

    @GetMapping("/")
    public String login(Login login, Model model){ return "login";}

    @PostMapping("/")
    public String postLogin(@Valid Login login, BindingResult bindingResult, Model model ){

        if (bindingResult.hasErrors()) {
            return "login";
        }

        if(!customerService.checkLogin(login).isSuccess()){
            model.addAttribute("loginError",true);
            return "login";
        }
        return "order";
    }
}
