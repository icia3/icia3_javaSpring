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
    private String b_title;

    //작성자(외래키)
    @ManyToOne
    @JoinColumn(name = "b_writer")
    private Member b_writer;

    //작성일자
    @CreationTimestamp
    @Column
    private Timestamp b_date;

    //상품이름
    @Column(nullable = false, length = 30)
    private String b_pname;

    //상품가격
    @Column(nullable = false)
    private long b_price;

    //판매지역
    @Column(nullable = false, length = 20)
    private String b_loc;

    //글 내용
    @Column(nullable = false)
    private String b_content;
}
