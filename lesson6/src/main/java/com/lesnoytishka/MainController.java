package com.lesnoytishka;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @RequestMapping("/hello")
    public String getMainPage() {
        return "hello world";
    }
}
