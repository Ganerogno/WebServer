package com.example.test.ServicesImpl;

import com.example.test.Entities.Customer;
import com.example.test.Repositories.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CustomerServiceImplTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerService;

//    @BeforeEach
//    public void setup(){
//        this.customerService = new CustomerServiceImpl(this.customerRepository);
//    }
    @Test
    void findAll() {
        System.out.println();
        List<Customer> customerList = customerService.FindAll().stream().toList();
        Assertions.assertNotNull(customerList);
    }
    @Test
    void add() {
        customerService.Add(new Customer("TestOleg","TestOleg@mail.ru",
                    "TestOlegPas","TestRussia", "TestMoscow", "FeMale"));
        List<Customer> customerList =  customerService.FindAll();
        Assertions.assertNotNull(customerList);
    }
}