package com.example.studaccjava.repository;

import com.example.studaccjava.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Long> {

    Role findByName (String name);
}
