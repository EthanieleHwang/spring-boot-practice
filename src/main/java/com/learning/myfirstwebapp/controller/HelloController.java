package com.learning.myfirstwebapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
        public ResponseEntity<String> sayHello() {
        System.out.println("Hello Controller: sayHello() method was called");
        return new ResponseEntity<String>("\"Hello Spring Boot! This is my first web api\"", HttpStatus.OK );
    }

    @GetMapping("/greet")
    public String greetSomeone(){
        return "Greetings,brave explorer!";
    }

    @GetMapping("/greet/{name}")
    public String greetSomeone(@PathVariable String name){
        return "Hello, "+name+"!";
    }

}
