package com.springreact.Spring_React;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @GetMapping("/api/hello2")
    public String hello2() {
        return "Hello from Spring boot 2";
    }

    @GetMapping("/api/longhello")
    public String longHello() {
        return "Hello from Spring Boot! " + "A".repeat(1000); }

    public String longHello2(){
        return "Hello from Springboot!" + "B".repeat(100);
    }

    public String longHello23(){
        return "Hello from Springboot!" + "B".repeat(100);
    }

    public String longHello233(){
        return "Hello from Springboot!" + "B".repeat(100);
    }
}