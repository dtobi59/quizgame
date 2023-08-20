package com.quizgame.quizgame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return  "Hello world, This is David in the Buidling";
    }
}
