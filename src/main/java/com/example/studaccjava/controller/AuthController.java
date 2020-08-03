package com.example.studaccjava.controller;



import com.example.studaccjava.config.jwt.JwtProvider;
import com.example.studaccjava.model.Tuser;
import com.example.studaccjava.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class AuthController {
    @Autowired
    private TuserService tuserService;
    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("api/v1/register")
    public String registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        Tuser u = new Tuser();
        u.setPasswordhash(registrationRequest.getPassword());
        u.setNickname(registrationRequest.getLogin());
        u.setEmail(registrationRequest.getEmail());
        u.setFirstname(registrationRequest.getFirstname());
        u.setSecondname(registrationRequest.getSecondname());
        u.setCourse(registrationRequest.getCourse());
        u.setFac(registrationRequest.getFac());
        u.setDep(registrationRequest.getDep());
        tuserService.saveTuser(u);
        return "OK";
    }

    @PostMapping("api/v1/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        Tuser tuser = tuserService.findByLoginAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(tuser.getNickname());
        return new AuthResponse(token);
    }
}
