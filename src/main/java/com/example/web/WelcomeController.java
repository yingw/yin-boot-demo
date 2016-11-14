package com.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yingu on 2016/11/14.
 */
@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Hello, Boot!";
    }
}