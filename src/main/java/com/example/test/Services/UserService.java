package com.example.test.Services;

import com.example.test.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    boolean save(User user);
    boolean delete(Long id);
    User findById(Long id);
    List<User> findAll();
}
