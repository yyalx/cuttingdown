package org.example.cuttingdown.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class HelloWorld {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
