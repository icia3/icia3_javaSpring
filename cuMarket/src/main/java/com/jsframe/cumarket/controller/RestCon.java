package com.jsframe.cumarket.controller;

import com.jsframe.cumarket.serivce.Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class RestCon {

    @Autowired
    private Service iServ;

    @PostMapping("idcheck")
    public String idchk(String mid){
        log.info("idcheck()");
        String res = iServ.search(mid);
        return res;
    }
    

}// 클래스 끝
