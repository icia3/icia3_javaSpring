package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "membertbl")
@Data
public class Member {
    @Id
    private String m_id;

    @Column(nullable = false, length = 60)
    private String m_pwd;

    @Column(nullable = false, length = 10)
    private String m_name;

    @Column(nullable = false, length = 10)
    private String m_birth;

    @Column(nullable = false, length = 40)
    private String m_mail;

    @Column(nullable = false, length = 20)
    private String m_phone;


}
