package com.springreact.Spring_React;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello(){
        return "Hello from Spring Boot!";
    }

    @GetMapping("/api/hello2")
    public String hello2(){
        return "Hello from Spring boot 2";
    }
}
