package com.fullstackproject.restaurant.customer_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResult {

    private boolean success;
    private boolean usernameExists;
    private boolean passwordMatch;
}
