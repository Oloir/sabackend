package com.example.studaccjava.controller;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationRequest {

    @NotEmpty
    private String login;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

//    @NotEmpty
    private String firstname;

//    @NotEmpty
    private String secondname;

//    @NotEmpty
    private int course;

//    @NotEmpty
    private int fac;

//    @NotEmpty
    private int dep;



}