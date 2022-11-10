package com.jsframe.cumarket.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managertbl")
@Data
public class Manager {

    //관리자 아이디
    @Id
    private String man_id;

    @Column(nullable = false, length = 30)
    private String man_pwd;
}
