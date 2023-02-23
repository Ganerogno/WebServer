package com.example.test.ServicesImpl;

import com.example.test.Entities.User;
import com.example.test.Repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerServiceImplTest {

    @Autowired
    private UserRepository customerRepository;

    @Autowired
    private UserServiceImpl customerService;

//    @BeforeEach
//    public void setup(){
//        this.customerService = new CustomerServiceImpl(this.customerRepository);
//    }
    @Test
    void findAll() {
        System.out.println();
        List<User> customerList = customerService.FindAll().stream().toList();
        Assertions.assertNotNull(customerList);
    }
    @Test
    void add() {
        customerService.Add(new User("TestOleg","TestOleg@mail.ru",
                    "TestOlegPas","TestRussia", "TestMoscow", "FeMale"));
        List<User> customerList =  customerService.FindAll();
        Assertions.assertNotNull(customerList);
    }
}