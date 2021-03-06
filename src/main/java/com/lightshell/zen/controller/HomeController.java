package com.lightshell.zen.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kevindong
 */
@RestController
@RequestMapping(path = "/home")
public class HomeController {

    @GetMapping(path = "/")
    public String home() {
        return "hello world";
    }

}
