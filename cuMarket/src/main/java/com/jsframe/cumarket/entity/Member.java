package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "membertbl")
@Data
public class Member {

    //회원 아이디
    @Id
    private String m_id;

    //비밀번호
    @Column(nullable = false, length = 60)
    private String m_pwd;

    //회원이름
    @Column(nullable = false, length = 10)
    private String m_name;

    //생일
    @Column(nullable = false, length = 10)
    private String m_birth;

    //이메일
    @Column(nullable = false, length = 40)
    private String m_mail;

    //전화번호
    @Column(nullable = false, length = 20)
    private String m_phone;


}
