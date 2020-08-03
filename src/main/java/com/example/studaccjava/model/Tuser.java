package com.example.studaccjava.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tuser", schema="social")
@Data
public class Tuser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "user_nickname")
    private String nickname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_passwordhash")
    private String passwordhash;

    @Column(name = "user_type")
    private int type;

    @Column(name = "user_firstname")
    private String firstname;

    @Column(name = "user_secondname")
    private String secondname;

    @Column(name = "user_course")
    private int course;

    @Column(name = "user_fac")
    private int fac;

    @Column(name = "user_dep")
    private int dep;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


}