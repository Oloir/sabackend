package com.example.studaccjava.repository;

import com.example.studaccjava.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {


    @Query(value = "SELECT * from social.faculty where faculty_type = '3' ", nativeQuery = true)
    List<Faculty> queryAll();


//    @Query("from social.faculty where fac_type = ?1 ")
//    List<Faculty> queryByType (int fac_type);
}
