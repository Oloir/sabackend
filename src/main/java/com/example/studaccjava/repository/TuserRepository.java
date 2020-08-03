package com.example.studaccjava.repository;

import com.example.studaccjava.model.Tuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuserRepository extends JpaRepository<Tuser, Long> {

    Tuser findByNickname(String nickname);

}
