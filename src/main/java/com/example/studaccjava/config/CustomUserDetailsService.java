package com.example.studaccjava.config;



import com.example.studaccjava.model.Tuser;
import com.example.studaccjava.service.TuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private TuserService tuserService;

    @Override
    public CustomUserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Tuser tuser = tuserService.findByLogin(nickname);
        return CustomUserDetails.fromTuserToCustomUserDetails(tuser);
    }
}