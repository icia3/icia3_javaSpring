package com.jsframe.cumarket.controller;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.entity.BoardFile;
import com.jsframe.cumarket.entity.Member;
import com.jsframe.cumarket.repository.BoardRepository;
import com.jsframe.cumarket.serivce.Service;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
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

    //회원가입 페이지 맵핑
    @GetMapping("join")
    public String join(){
        log.info("join()");
        return "join";
    }

    //회원가입 기능 맵핑
    @PostMapping("writeProc")
    public String writeProc(Member member, RedirectAttributes rttr){
        log.info("writeProc()");
        String view = Serv.insertMember(member,rttr);

        return view;
    }

    //로그인 페이지 맵핑
    @GetMapping("login")
    public String login(){
        log.info("login");
        return "login";
    }

    //로그인 기능 맵핑
    @PostMapping("loginProc")
    public String loginProc(Member member, RedirectAttributes rttr, HttpSession session){
        log.info("loginProc()");
        String view = Serv.loginProc(member, rttr, session);

        return view;
    }

    //게시글 등록 페이지 맵핑
    @GetMapping("register")
    public String register(){
        log.info("register()");
        return "register";

    }

    //게시글 등록 기능 맵핑
    @PostMapping("regProc")
    public String regProc(@RequestPart List<MultipartFile> files, Board board, HttpSession session, RedirectAttributes rttr){
        log.info("regProc()");
        String view = Serv.regProc(files,board,session,rttr);
        return view;
    }

    //게시글 파일 첨부 기능 맵핑
    @GetMapping("download")
    public ResponseEntity<Resource> fileDownload(BoardFile bfile, HttpSession session) throws
            IOException {
        ResponseEntity<Resource> resp = Serv.fileDownlaod(bfile, session);
        return resp;

    }

    //리스트 페이지 맵핑
    @GetMapping ("list")
    public ModelAndView getList(Integer pageNum, HttpSession session){
        log.info("getList()");
        mv = Serv.getBoardList(pageNum, session);
        mv.setViewName("list");
        return mv;
    }

    //상세정보 페이지 맵핑
    @GetMapping("detail")
    public ModelAndView detail(long bnum, HttpSession session){
        log.info("detail()");
        mv = new ModelAndView();
        mv = Serv.getBoard(bnum);
        //session에서 login정보 받아오도록 처리해서 detail로 넘겨줌
        mv.addObject("login", session.getAttribute("loginId"));
        mv.setViewName("detail");
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


    //수정 기능 맵핑
    @PostMapping("updateProc")
    public String updateProc(List<MultipartFile> files,
                             Board board,
                             HttpSession session,
                             RedirectAttributes rttr){
        log.info("updateProc()");
        String view = Serv.boardUpdate(files, board, session, rttr);

        return view;
    }

    //로그아웃 기능 맵핑
    @GetMapping("logout")
    public String logout(HttpSession session){
        log.info("logout()");
        session.invalidate();
        return "home";
    }

    //삭제 기능 맵핑
    @GetMapping("delete")
    public String delete(long bnum, HttpSession session, RedirectAttributes rttr){
        log.info("delete()");
        String view = Serv.deleteProc(bnum,session,rttr);
        return view;
    }

    //검색 기능 맵핑
    @GetMapping("searchProd")
    public ModelAndView searchProd(Integer pageNum, HttpSession session,String word,RedirectAttributes rttr){
        log.info("searchProc()");
        log.info(word);
        mv = Serv.searching(pageNum, session,word,rttr);
        mv.setViewName("list2");
        return mv;
    }
}
