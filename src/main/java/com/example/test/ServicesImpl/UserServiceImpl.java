package com.example.test.ServicesImpl;

import com.example.test.Entities.User;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//    CustomerServiceImpl(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }
    @Override
    public void Add(User user){
        userRepository.save(user);
    }
    @Override
    public void Delete(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public User FindById(Long id){
        return userRepository.findById(id).get();
    }
    @Override
    public List<User> FindAll(){
        return userRepository.findAll().stream().toList();
    }
}
