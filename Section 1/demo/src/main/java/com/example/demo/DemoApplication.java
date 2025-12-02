package com.example.demo; // your package , folder

import org.springframework.boot.SpringApplication; // start the program
import org.springframework.boot.autoconfigure.SpringBootApplication; // annotation , this class is the main class



@SpringBootApplication // annotation Consisting of 3 annotations :
// @configuration
// @EnableAutoConfiguration
// @ComponentScan // بيروح يدور علي الانوتيشن اللي في البرنامج

public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
