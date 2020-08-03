package com.example.studaccjava.controller;


import com.example.studaccjava.model.Feed;
import com.example.studaccjava.service.FeedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feed")
public class FeedControllerV1 {

    private final FeedService feedService;

    public FeedControllerV1 (FeedService feedService){
        this.feedService = feedService;
    }

    @GetMapping(value = "{subject}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Feed>> getFeed (@PathVariable("subject") int subject){

        if (subject == 0){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


        List<Feed> feedList = this.feedService.getFeedBySubject(subject);
        if (feedList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(feedList, HttpStatus.OK);
    }


}
