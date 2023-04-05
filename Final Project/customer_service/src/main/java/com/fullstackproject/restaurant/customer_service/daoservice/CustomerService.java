package com.fullstackproject.restaurant.customer_service.daoservice;

import com.fullstackproject.restaurant.customer_service.model.Login;
import com.fullstackproject.restaurant.customer_service.model.LoginResult;
import com.fullstackproject.restaurant.customer_service.repository.UsernamePasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    UsernamePasswordRepository usernamePwdDao;

    public LoginResult checkLogin(Login login){
       Optional<Login> opt =  usernamePwdDao.findById(login.getUsername().toLowerCase(Locale.ROOT));
       LoginResult loginResult =  null;

       if(opt.isPresent()) {
           Login storedLogin = opt.get();
           boolean pwdMatches = login.getPassword().equals(storedLogin.getPassword());
           loginResult = new LoginResult(pwdMatches, true, pwdMatches);
       }
       else{
            loginResult = new LoginResult(false,false,false);
           }

       return loginResult;
       }




}
