package com.example.studaccjava.repository;

import com.example.studaccjava.model.Router;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  RouterRepository extends JpaRepository<Router, Long> {

    Router findByTypeAndItem (int type, int item);
}
