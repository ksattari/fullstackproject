package com.fullstackproject.restaurant.customer_service.configuration;

import com.fullstackproject.restaurant.customer_service.model.MenuItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class ConfigurationClass{

    @Bean
    public List<MenuItem> generateMenu(){

        List<MenuItem> menu = new ArrayList<>();

        menu.add(new MenuItem(1,"Hamburger",8.95));
        menu.add(new MenuItem(2,"Fish n Chips",12.95));
        menu.add(new MenuItem(3,"Noodles",10.95));

        return menu;

    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
