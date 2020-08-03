package com.example.studaccjava.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSecurityController {

    @GetMapping("api/v1/admin/get")
    public String getAdmin() {
        return "Hi admin";
    }

    @GetMapping("api/v1/user/get")
    public String getTuser() {
        return "Hi Tuser";
    }
}