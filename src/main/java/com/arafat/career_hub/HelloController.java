package com.arafat.career_hub;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }


    @GetMapping("/hi")
    public String hi() {
        return "Hi arafat";
    }
}
