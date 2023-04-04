package com.fullstackproject.restaurant.customer_service.repository;

import com.fullstackproject.restaurant.customer_service.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsernamePasswordRepository extends JpaRepository<Login,String> {
}
