package com.ogawalucas.oauthapi.user.resoruces;

import com.ogawalucas.oauthapi.user.entities.User;
import com.ogawalucas.oauthapi.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserResources {

    @Autowired
    private UserService service;

    @GetMapping("search")
    public User findAll(@RequestParam String email) {
        return service.findAll(email);
    }
}
