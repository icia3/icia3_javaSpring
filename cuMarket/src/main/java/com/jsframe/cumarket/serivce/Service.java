package com.jsframe.cumarket.serivce;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.repository.BoardRepository;

import com.jsframe.cumarket.util.PagingUtil;

import com.jsframe.cumarket.repository.MemberRepository;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    //리스트에 페이징 처리
    public ModelAndView getBoardList(Integer pageNum, HttpSession session){
        log.info("getBoardList()");
        mv = new ModelAndView();

        if (pageNum == null){//처음에 접속했을 때는 pageNum이 넘어오지 않는다.
            pageNum = 1;
        }

        int listCnt = 5;//페이지 당 보여질 게시글의 개수.
        //페이징 조건 생성
        Pageable pb = PageRequest.of((pageNum - 1), listCnt,
                Sort.Direction.DESC, "bnum"); //Sort 정렬, Direction 방향, DESC 내림차순, bnum 기준

        Page<Board> result = bRepo.findByBnumGreaterThan(0L,pb);
        List<Board> bList = result.getContent();
        int totalPage = result.getTotalPages();//전체 페이지 개수

        String paging = getPaging(pageNum, totalPage);

        mv.addObject("bList", bList);
        mv.addObject("paging", paging);

        //현재 보이는 페이지의 번호를 저장.
        session.setAttribute("pageNum", pageNum);

        return mv;
    }
    //페이징 처리 2
    private String getPaging(Integer pageNum, int totalPage) {
        String pageHtml = null;
        int pageCnt = 2;//보여질 페이지 번호 개수
        String listName = "?";//게시판 분류 이름(현재 없음)

        PagingUtil paging = new PagingUtil(totalPage, pageNum,
                pageCnt, listName);

        pageHtml = paging.makePaging();

        return pageHtml;
    }

    //게시글 수정
    @Transactional
    public String boardUpdate(List<MultipartFile> files,
                              Board board,
                              HttpSession session,
                              RedirectAttributes rttr){
        log.info("boardUpdate()");
        String msg = null;
        String view = null;

        try {
            bRepo.save(board);//insert, update 겸용.
            fileUpload(files, session, board);//신규 파일 업로드 처리

            msg = "수정 성공";
            view = "redirect:detail?bnum=" + board.getBnum();
        }catch (Exception e){
            e.printStackTrace();
            msg = "수정 실패";
            view = "redirect:updateFrm?bnum=" + board.getBnum();
        }
        rttr.addFlashAttribute("msg", msg);//메시지 전달.

        return view;
    }

    //게시글 업로드(메소드만 만들어 놨음)
    private void fileUpload(List<MultipartFile> files, HttpSession session, Board board) {
    }

    /*
    public String loginProc(String m_id){
        log.info("loginProc()");
        String msg = null;
        String view = null;



    }*/

}
