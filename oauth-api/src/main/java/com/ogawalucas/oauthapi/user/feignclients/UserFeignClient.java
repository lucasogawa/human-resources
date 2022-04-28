package com.ogawalucas.oauthapi.user.feignclients;

import com.ogawalucas.oauthapi.user.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "user-api", path = "/users")
public interface UserFeignClient {

    @GetMapping("search")
    User findAll(@RequestParam String email);
}
