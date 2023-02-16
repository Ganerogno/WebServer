package com.example.test;

import com.example.test.Customers.CustomerRepository;
import com.example.test.Customers.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class TempLoadDataBase {
//    private static final Logger log = LoggerFactory.getLogger(TempLoadDataBase.class);
//
//    @Bean
//    CommandLineRunner initDataBase(CustomerRepository customerRepository){
//        return args -> {
//            customerRepository.save(new Customer("Oleg","Oleg@mail.ru",
//                    "OlegPas","Russia", "Moscow", "Male"));
//            customerRepository.save(new Customer("NotOleg","NotOleg@mail.ru",
//                    "NotOlegPas","NotRussia", "NotMoscow", "FeMale"));
//            customerRepository.findAll().forEach(customer ->
//                    log.info("Loaded" + customer));
//        };
//    }
//}
