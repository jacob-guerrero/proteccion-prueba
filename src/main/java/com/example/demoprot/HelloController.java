package com.example.demoprot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String healthCheck() {
        return "System Online! Deployed via Render.";
    }
}