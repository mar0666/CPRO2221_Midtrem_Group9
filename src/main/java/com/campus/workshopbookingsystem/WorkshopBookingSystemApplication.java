package com.campus.workshopbookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.campus")
@EntityScan(basePackages = "com.campus")
@EnableJpaRepositories(basePackages = "com.campus")
public class WorkshopBookingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorkshopBookingSystemApplication.class, args);
    }

}