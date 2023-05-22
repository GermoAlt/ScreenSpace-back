package com.uade.screenspace.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/goodbye")
    public String helloWorld(){
        return "Hello World from Spring Boot";
    }
}