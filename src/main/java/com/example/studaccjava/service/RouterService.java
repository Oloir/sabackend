package com.example.studaccjava.service;


import com.example.studaccjava.model.Router;
import com.example.studaccjava.repository.RouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouterService {

    @Autowired
    private final RouterRepository routerRepository;


    public RouterService (RouterRepository routerRepository){
        this.routerRepository = routerRepository;
    }


    public Router findByTypeAndItem (int type, int item){
        return routerRepository.findByTypeAndItem(type, item);
    }


}
