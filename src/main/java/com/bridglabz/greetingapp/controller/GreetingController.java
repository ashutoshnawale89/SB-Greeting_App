package com.bridglabz.greetingapp.controller;

import com.bridglabz.greetingapp.model.Greeting;
import com.bridglabz.greetingapp.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/greetings")
public class GreetingController {

    private static  final String templates="Hello, %s %s!";
    private final AtomicLong counter=new AtomicLong();
    @GetMapping
    public Greeting greeting(@RequestParam String firstName, @RequestParam String lastName){
      return new Greeting(counter.incrementAndGet(),String.format(templates,firstName,lastName));
    }



}
