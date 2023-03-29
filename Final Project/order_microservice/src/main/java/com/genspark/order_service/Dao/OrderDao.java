package com.genspark.order_service.Dao;

import com.genspark.order_service.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Long> {
}
