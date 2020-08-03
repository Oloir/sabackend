package com.example.studaccjava.controller;


import com.example.studaccjava.model.Faculty;
import com.example.studaccjava.model.Router;
import com.example.studaccjava.service.RouterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/router")
public class RouterControllerV1 {



    @Autowired
    private final RouterService routerService;

    public RouterControllerV1 (RouterService routerService){
        this.routerService = routerService;
    }


    @GetMapping(value = "{item}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Router> getRouterId(@PathVariable("item") int item){
        if (item == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Router router = this.routerService.findByTypeAndItem(3, item);

        if (router == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(router, HttpStatus.OK);
    }

}
