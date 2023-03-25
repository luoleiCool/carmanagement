package com.luol.carmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author luolei
 */
@SpringBootApplication
@AutoConfiguration
@ComponentScan(basePackages = {"com.***"})
public class CarmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarmanagementApplication.class, args);
    }

}
