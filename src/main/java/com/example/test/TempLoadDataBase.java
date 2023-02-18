package com.example.test;

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
