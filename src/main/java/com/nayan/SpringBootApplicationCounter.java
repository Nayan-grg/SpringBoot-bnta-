package com.nayan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringBootApplicationCounter {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationCounter.class, args);
        //Don't put "static int count=0;" inside the main method. It needs to be outside the method.
    }

    static int count=0;

    @GetMapping(path = "current-count")
    public int getCurrentCount(){
        return count;
    }

    @GetMapping(path = "increment-count")
    public int incrementCount(){
        return ++count;
    }

    @GetMapping(path = "decrement-count")
    public int decrementCount(){
        return --count;
    }




    // All methods should have a @GetMapping
    // Create a method to get current count. i.e localhost:8080/current-count
    // Create method to increment the count. i.e localhost:8080/increment-count
    // Create method to decrement the count. i.e localhost:8080/decrement-count
    // Test your api with chrome
}
