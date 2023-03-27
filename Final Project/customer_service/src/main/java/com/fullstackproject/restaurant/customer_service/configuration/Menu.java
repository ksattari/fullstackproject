package com.fullstackproject.restaurant.customer_service.configuration;

import com.fullstackproject.restaurant.customer_service.model.MenuItem;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Menu {

    @Bean
    public List<MenuItem> generateMenu(){

        List<MenuItem> menu = new ArrayList<>();

        menu.add(new MenuItem(0,"Hamburger",8.95));
        menu.add(new MenuItem(0,"Fish n Chips",12.95));

        return menu;

    }
}
