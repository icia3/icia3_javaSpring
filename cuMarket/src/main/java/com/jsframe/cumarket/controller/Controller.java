package com.jsframe.cumarket.controller;



import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.entity.BoardFile;
import com.jsframe.cumarket.entity.Member;
import com.jsframe.cumarket.repository.BoardRepository;
import com.jsframe.cumarket.serivce.Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;


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

    @GetMapping("main")
    public String main(){
        log.info("main()");
        return "main";
    }

    @GetMapping("join")
    public String join(){
        log.info("join()");
        return "join";
    }

    @PostMapping("writeProc")
    public String writeProc(Member member, RedirectAttributes rttr){
        log.info("writeProc()");
        String view = Serv.insertMember(member,rttr);

        return view;
    }

    @GetMapping("login")
    public String login(){
        log.info("login");

        return "login";
    }

    @PostMapping("loginProc")
    public String loginProc(Member member, RedirectAttributes rttr, HttpSession session){
        log.info("loginProc()");
        String view = Serv.loginProc(member, rttr, session);

        return view;
    }


    @GetMapping("detail")
    public ModelAndView detail(long bnum){
        log.info("detail()");
        mv = new ModelAndView();
        mv = Serv.getBoard(bnum);
        mv.setViewName("detail");
        return mv;
    }

    //리스트 페이지 맵핑
    @GetMapping ("list")
    public ModelAndView getList(Integer pageNum, HttpSession session){
        log.info("getList()");
        mv = Serv.getBoardList(pageNum, session);
        mv.setViewName("list");
        return mv;
    }

    //수정 페이지 맵핑
    @GetMapping("updateFrm")
    public ModelAndView updateFrm(long bnum){
        log.info("updateFrm()");
        mv = Serv.getBoard(bnum);
        mv.setViewName("updateFrm");
        return mv;
    }


    //수정 매소드 맵핑
    @PostMapping("updateProc")
    public String updateProc(List<MultipartFile> files,
                             Board board,
                             HttpSession session,
                             RedirectAttributes rttr){
        log.info("updateProc()");
        String view = Serv.boardUpdate(files, board, session, rttr);

        return view;
    }

    @GetMapping("register")
    public String register(){
        log.info("register()");
        return "register";

    }

    @PostMapping("regProc")
    public String regProc(@RequestPart List<MultipartFile> files, Board board, HttpSession session, RedirectAttributes rttr){
        log.info("regProc()");
        String view = Serv.regProc(files,board,session,rttr);
        return view;
    }

    @GetMapping("download")
    public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session) throws
            IOException {
        ResponseEntity<Resource> resp = Serv.fileDownlaod(bfile, session);
        return resp;

    }

}
