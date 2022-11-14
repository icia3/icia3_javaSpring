package com.jsframe.cumarket.repository;

import com.jsframe.cumarket.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Long> {

Page<Board> findByBnumGreaterThan(long bnum, Pageable pageable);

    void deleteByBnum(long bnum);
}
