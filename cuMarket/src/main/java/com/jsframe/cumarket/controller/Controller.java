package com.jsframe.cumarket.controller;

import com.jsframe.cumarket.repository.BoardRepository;
import com.jsframe.cumarket.serivce.Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
@Log
public class Controller {
    ModelAndView mv;

    @Autowired
    private Service Serv;

    @GetMapping("/")
    public String home(){
        log.info("home()");
        return "home";
    }

    @GetMapping("join")
    public String join(){
        log.info("join()");
        return "join";
    }

    @GetMapping("login")
    public String login(){
        log.info("login");
        return "login";
    }


    @GetMapping("detail")
    public ModelAndView detail(long bnum){
        log.info("detail()");
        mv = new ModelAndView();
        mv = Serv.getBoard(bnum);
        mv.setViewName("detail");
        return mv;
    }

}
