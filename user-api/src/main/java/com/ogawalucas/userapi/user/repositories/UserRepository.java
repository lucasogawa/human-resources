package com.ogawalucas.userapi.user.repositories;

import com.ogawalucas.userapi.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
