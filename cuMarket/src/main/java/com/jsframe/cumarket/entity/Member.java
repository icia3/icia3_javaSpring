package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "membertbl")
@Data
public class Member {

    //회원 아이디
    @Id
    private String mid;

    //비밀번호
    @Column(nullable = false, length = 60)
    private String mpwd;

    //회원이름
    @Column(nullable = false, length = 10)
    private String mname;

    //생일
    @Column(nullable = false, length = 10)
    private String mbirth;

    //이메일
    @Column(nullable = false, length = 40)
    private String mmail;

    //전화번호
    @Column(nullable = false, length = 20)
    private String mphone;


}
