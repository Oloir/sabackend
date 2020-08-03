package com.example.studaccjava.service;

import com.example.studaccjava.model.Faculty;
import com.example.studaccjava.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    public Faculty findFacultyById (long id){
        return facultyRepository.findById(id).get();
    }

    public List<Faculty> findAllFaculties(){
        return facultyRepository.findAll();
    }


    public List<Faculty> queryAll(){
        return facultyRepository.queryAll();
    }


//      Тестовая ебота, можно удалять
//    public List <Faculty> queryByType(int type){
//        return facultyRepository.queryByType(type);
//    }



}
