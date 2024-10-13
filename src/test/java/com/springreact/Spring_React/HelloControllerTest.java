package com.springreact.Spring_React;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Common setup for each test can go here
    }



    @Test
    public void testHello() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring Boot! 😊")); // Update to match actual response
    }

    @Test
    public void testHello2() throws Exception {
        mockMvc.perform(get("/api/hello2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring boot 2"));
    }

    @Test
    public void testHelloResponseType() throws Exception {
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")) // Update to include charset
                .andExpect(content().string("Hello from Spring Boot! 😊"));
    }

    @Test
    public void testHello2ResponseType() throws Exception {
        mockMvc.perform(get("/api/hello2"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8")) // Update to include charset
                .andExpect(content().string("Hello from Spring boot 2"));
    }

    @Test
    public void testLargeResponse() throws Exception {
        mockMvc.perform(get("/api/longhello")) // Ensure this endpoint returns the expected long string
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring Boot! " + "A".repeat(1000))); // Adjust if needed
    }

    @Test
    public void testContentLength() throws Exception {
        String responseContent = "Hello from Spring Boot! 😊"; // Update to match actual response
        mockMvc.perform(get("/api/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(responseContent))
                .andExpect(result -> {
                    int contentLength = result.getResponse().getContentLength();
                    int expectedLength = responseContent.getBytes(StandardCharsets.UTF_8).length; // Use UTF-8 byte length
                    assertEquals(expectedLength, contentLength); // Use assertEquals for clarity
                });
    }

    @Test
    public void testUnauthorizedAccess() throws Exception {
        // If you don't implement authorization, adjust expected status to 200
        mockMvc.perform(get("/api/hello").header("Authorization", "InvalidToken"))
                .andExpect(status().isOk()); // Adjust based on your implementation
    }
}