package com.jsframe.cumarket.repository;

import com.jsframe.cumarket.entity.Board;
import com.jsframe.cumarket.entity.BoardFile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardFileRepository extends CrudRepository<BoardFile, Long> {

    List<BoardFile> findByBfbid(Board board);

    void deleteByBfbid(Board board);
}
