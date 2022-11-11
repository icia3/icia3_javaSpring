package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "commenttbl")
@Data
public class Comment {

    //댓글 번호
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long rnum;

    //작성자 아이디
    @ManyToOne
    @JoinColumn(name = "rid")
    private Member rid;

    //댓글 내용
    @Column(nullable = false, length = 100)
    private String reply;

}
