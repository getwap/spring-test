package com.springreact.Spring_React.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String hello() {
        return "Hello from Spring Boot! 😊";
    }

    @GetMapping("/api/hello2")
    public String hello2() {
        return "Hello from Spring Boot 2!";
    }

    @GetMapping("/api/longhello")
    public String longHello() {
        return "Hello from Spring Boot! " + "A".repeat(1000); // Long string
    }

    // New endpoint returning a personalized greeting
    @GetMapping("/api/greet/{name}")
    public String greet(@PathVariable String name) {
        return "Hello, " + name + "! Welcome to Spring Boot!";
    }

    // New endpoint with a query parameter
    @GetMapping("/api/greet")
    public String greetWithParam(@RequestParam(value = "name", defaultValue = "Guest") String name) {
        return "Hello, " + name + "! How can we assist you today?";
    }

    // New endpoint returning a JSON response
    @GetMapping("/api/json")
    public Map<String, String> jsonResponse() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from Spring Boot in JSON format!");
        response.put("status", "success");
        return response;
    }

    // New endpoint returning a motivational quote
    @GetMapping("/api/quote")
    public String quote() {
        return "Believe you can and you're halfway there.";
    }
}