package com.jsframe.cumarket.serivce;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.repository.BoardRepository;
import com.jsframe.cumarket.repository.MemberRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Service
@Log
public class Service {
    ModelAndView mv;

    @Autowired
    private BoardRepository bRepo;

    @Autowired
    private MemberRepository mRepo;

    public ModelAndView getBoard(long bnum){
        log.info("getBoard()");
        mv= new ModelAndView();

        //게시글 담기
        Board board = bRepo.findById(bnum).get();
        mv.addObject("board", board);
        return mv;
    }

    /*
    public String loginProc(String m_id){
        log.info("loginProc()");
        String msg = null;
        String view = null;



    }*/


}
