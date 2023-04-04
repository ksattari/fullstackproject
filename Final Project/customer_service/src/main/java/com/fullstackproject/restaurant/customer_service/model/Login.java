package com.fullstackproject.restaurant.customer_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_login")
public class Login {

    @Id
    private String username;
    private String password;
}
