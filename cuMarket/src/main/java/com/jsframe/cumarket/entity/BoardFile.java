package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "boardfiletbl")
@Data
public class BoardFile {

    //게시물파일 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bfnum;

    //Board 게시글번호
    @ManyToOne
    @JoinColumn(name = "bfbid")
    private Board bfbid;

    //게시물파일 시스템이름
    @Column(nullable = false, length = 50)
    private String bfsysname;

    //게시물 파일 원래 이름
    @Column(nullable = false, length = 50)
    private String bforiname;
}
