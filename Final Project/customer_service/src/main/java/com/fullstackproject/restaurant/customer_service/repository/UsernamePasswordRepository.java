package com.fullstackproject.restaurant.customer_service.repository;

import com.fullstackproject.restaurant.customer_service.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsernamePasswordRepository extends JpaRepository<Login,String> {
}
