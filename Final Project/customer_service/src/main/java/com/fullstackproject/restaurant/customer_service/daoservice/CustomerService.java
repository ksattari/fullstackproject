package com.fullstackproject.restaurant.customer_service.daoservice;

import com.fullstackproject.restaurant.customer_service.repository.UsernamePasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService {

    @Autowired
    UsernamePasswordRepository UPDao;


}
