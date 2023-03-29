package com.genspark.order_service.Dao;

import com.genspark.order_service.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<MenuItem, Long> {
}
