package com.clone.insta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class BasicController {

    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/sign-in")
    public String signIn() {
        return "sign/sign-in";
    }
    
}
