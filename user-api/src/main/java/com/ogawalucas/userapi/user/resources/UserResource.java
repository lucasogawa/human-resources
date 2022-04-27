package com.ogawalucas.userapi.user.resources;

import com.ogawalucas.userapi.commons.expections.NotFoundException;
import com.ogawalucas.userapi.user.entities.User;
import com.ogawalucas.userapi.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserResource {

    @Autowired
    private UserRepository repository;

    @GetMapping("{id}")
    public User findById(@PathVariable Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new NotFoundException("User"));
    }

    @GetMapping("search")
    public User findAll(@RequestParam String email) {
        return repository.findByEmail(email);
    }
}
