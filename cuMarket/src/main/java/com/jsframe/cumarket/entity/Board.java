package com.jsframe.cumarket.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "boardtbl")
@Data
public class Board {
    //게시글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bnum;

    //게시글 제목
    @Column(nullable = false, length = 50)
    private String btitle;

    //작성자(외래키)
    @ManyToOne
    @JoinColumn(name = "bwriter")
    private Member bwriter;

    //작성일자
    @CreationTimestamp
    @Column
    private Timestamp bdate;

    //상품이름
    @Column(nullable = false, length = 30)
    private String bpname;

    //상품가격
    @Column(nullable = false)
    private long bprice;

    //판매지역
    @Column(nullable = false, length = 20)
    private String bloc;

    //글 내용
    @Column(nullable = false)
    private String bcontent;
}
