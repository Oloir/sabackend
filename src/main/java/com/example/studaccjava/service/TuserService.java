package com.example.studaccjava.service;


import com.example.studaccjava.model.Role;
import com.example.studaccjava.model.Tuser;
import com.example.studaccjava.repository.RoleRepository;
import com.example.studaccjava.repository.TuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class TuserService {


    private final TuserRepository tuserRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    @Autowired
    public TuserService(TuserRepository tuserRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.tuserRepository = tuserRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    public Tuser saveTuser(Tuser tuser) {
        Role role = roleRepository.findByName("ROLE_USER");
        tuser.setRole(role);
        tuser.setType(1);
        tuser.setPasswordhash(passwordEncoder.encode(tuser.getPasswordhash()));
        return tuserRepository.save(tuser);

    }

    public Tuser findByLogin(String nickname) {
        return tuserRepository.findByNickname(nickname);
    }

    public Tuser findByLoginAndPassword(String nickname, String passwordhash) {
        Tuser tuser = findByLogin(nickname);
        if (tuser != null) {
            if (passwordEncoder.matches(passwordhash, tuser.getPasswordhash())) {
                return tuser;
            }
        }
        return null;
    }
}