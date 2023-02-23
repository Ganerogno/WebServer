package com.example.test.Services;

import com.example.test.Entities.User;
import java.util.List;

public interface UserService {
    void Add(User user);
    void Delete(Long id);
    User FindById(Long id);
    List<User> FindAll();
}
