package br.com.igormartinez.greetingservice.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RestController;

import br.com.igormartinez.greetingservice.config.GreetingProperties;
import br.com.igormartinez.greetingservice.models.Greeting;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    
    private static final String template = "%s, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final GreetingProperties config;

    public GreetingController(GreetingProperties config) {
        this.config = config;
    }

    @GetMapping()
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "") String name) {

        if (name.isEmpty()) name = config.getDefaultValue();

        return new Greeting(
            counter.incrementAndGet(), 
            String.format(template, config.getGreeting(), name)
        );
    }
}
