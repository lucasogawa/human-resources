package com.ogawalucas.oauthapi.user.services;

import com.ogawalucas.oauthapi.user.entities.User;
import com.ogawalucas.oauthapi.user.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserFeignClient feignClient;

    public User findAll(String email) {
        return feignClient.findAll(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return feignClient.findAll(username);
    }
}
