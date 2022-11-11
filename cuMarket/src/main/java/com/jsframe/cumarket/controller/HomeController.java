package com.jsframe.cumarket.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log
public class HomeController {
    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("login")
    public String login(){
        log.info("login()");
        return "login";
    }

    @GetMapping("join")
    public String join(){
        log.info("join()");
        return "join";
    }
}
