package com.jsframe.cumarket.serivce;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.entity.Member;
import com.jsframe.cumarket.repository.BoardRepository;
import com.jsframe.cumarket.repository.MemberRepository;
import lombok.extern.java.Log;
import org.hibernate.metamodel.model.domain.internal.MapMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Transactional
    public String insertMember(Member member, RedirectAttributes rttr) {
        log.info("insertMember()");
        String msg = null;
        String view = null;

        try {
            mRepo.save(member);//

            view = "redirect:/";//목록 화면으로 돌아가기.
            msg = "회원가입 성공";
        }catch (Exception e){
            e.printStackTrace();
            view = "redirect:join";
            msg = "회원가입 실패";
        }
        rttr.addFlashAttribute("msg",msg);

        return view;
    }



    public String loginProc (Member member, RedirectAttributes rttr){
        log.info("loginProc()");
        String msg = null;
        String view = null;



        Member mem1 = new Member();
        Board bor1 = new Board();

        mem1.setMid("aa");
        bor1.setBwriter(mem1);
        Member me2 = bor1.getBwriter();
        log.info(me2.getMid());


        //입력한 pwd
        String cPwd = member.getMpwd();

        Member mData = mRepo.findByMid(member.getMid());
        String getPwd = mData.getMpwd();
        log.info(getPwd);
        log.info(cPwd);
        if(cPwd.equals(getPwd)){
            msg = "로그인 성공";
            view = "redirect:/";
        }
        else{
            msg = "로그인 실패";
            view = "redirect:login";
        }

        rttr.addFlashAttribute("msg", msg);
        return view;





    }


}
