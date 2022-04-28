package com.ogawalucas.oauthapi.user.services;

import com.ogawalucas.oauthapi.user.entities.User;
import com.ogawalucas.oauthapi.user.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient feignClient;

    public User findAll(String email) {
        return feignClient.findAll(email);
    }
}
