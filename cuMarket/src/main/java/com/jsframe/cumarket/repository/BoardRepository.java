package com.jsframe.cumarket.repository;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {

Page<Board> findByBnumGreaterThan(long bnum, Pageable pageable);

List<Board> findByBpname(String bpname);

List<Board> findByBtitle(String btitle);

    void deleteByBnum(long bnum);
}
