package com.rajesh.cardatabase;

import com.rajesh.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CardatabaseApplication {

    private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private UserRepository userRepository;


    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("App started ...");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {

            //Add owner object and save to DB
            Owner owner1 = new Owner("Rajesh", "Mohanty");
            Owner owner2 = new Owner("Swetalina", "Rout");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);
            carRepository.save(new Car("Ford", "Mustang", "Red",
                    "ADF-1121", 2017, 59000, owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White",
                    "SSJ-3002", 2014, 29000, owner1));
            carRepository.save(new Car("Toyota", "Prius", "Silver",
                    "KKO-0212", 2018, 39000, owner1));
            carRepository.save(new Car("Maruti", "Swift", "Red",
                    "KA23 MN7774", 2011, 20000, owner2));
            carRepository.save(new Car("Hyundai", "Santro", "Black",
                    "SSJ-3002", 2016, 500000, owner2));
            carRepository.save(new Car("Ford", "Figo", "Silver",
                    "KKO-0212", 2018, 39000, owner2));

            // username: user password: user
            userRepository.save(new User("user",
                    "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi",
                    "USER"));
            // username: admin password: admin
            userRepository.save(new User("admin",
                    "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG",
                    "ADMIN"));
        };
    }

}

