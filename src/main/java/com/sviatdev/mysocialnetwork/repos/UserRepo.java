package com.sviatdev.mysocialnetwork.repos;

import com.sviatdev.mysocialnetwork.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
