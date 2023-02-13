package com.example.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TempLoadDataBase {
    private static final Logger log = LoggerFactory.getLogger(TempLoadDataBase.class);

    @Bean
    CommandLineRunner initDataBase(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer("Oleg","Russia"));
            customerRepository.save(new Customer("NotOleg","NotRussia"));
            customerRepository.findAll().forEach(customer ->
                    log.info("Loaded" + customer));
        };
    }
}
