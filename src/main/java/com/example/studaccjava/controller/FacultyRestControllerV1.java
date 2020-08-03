package com.example.studaccjava.controller;


import com.example.studaccjava.model.Faculty;
import com.example.studaccjava.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/faculties")
public class FacultyRestControllerV1 {

    @Autowired
    private final FacultyService facultyService;


    public FacultyRestControllerV1(FacultyService facultyService) {
        this.facultyService = facultyService;
    }




    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculty> getFaculty (@PathVariable("id") Long facultyId){

        if (facultyId == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Faculty faculty = this.facultyService.findFacultyById(facultyId);
        if (faculty == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(faculty, HttpStatus.OK);
    }


    @GetMapping (value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faculty>> getAllFaculties(){
        List<Faculty> facultyList = facultyService.findAllFaculties();

        if(facultyList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(facultyList, HttpStatus.OK);

    }


    @GetMapping (value = "test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Faculty>> queryAll (){
        List<Faculty> facultyList = facultyService.queryAll();

        return new ResponseEntity<>(facultyList, HttpStatus.OK);
    }

//    @GetMapping (value = "/test/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Faculty>> queryByType(@PathVariable("type") int type){
//        List<Faculty> facultyList = facultyService.queryByType(type);
//
//        return new ResponseEntity<>(facultyList, HttpStatus.OK);
//    }



}
