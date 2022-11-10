package com.jsframe.cumarket.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
@Log
public class Controller {

    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("login")
    public String login(){
        log.info("login");
        return "login";
    }

    @GetMapping("join")
    public String join(){
        log.info("join()");
        return "join";
    }
}
