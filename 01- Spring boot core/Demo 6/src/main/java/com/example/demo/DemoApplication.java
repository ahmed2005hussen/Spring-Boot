package com.example.demo; // your package , folder

import org.springframework.boot.SpringApplication; // start the program
import org.springframework.boot.autoconfigure.SpringBootApplication; // annotation , this class is the main class


@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }
}
