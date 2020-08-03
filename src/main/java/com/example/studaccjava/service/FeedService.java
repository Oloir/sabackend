package com.example.studaccjava.service;


import com.example.studaccjava.model.Feed;
import com.example.studaccjava.repository.FeedRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedService {


    private final FeedRepository feedRepository;


    public FeedService (FeedRepository feedRepository){
        this.feedRepository = feedRepository;
    }

    public List<Feed> getFeedBySubject (int subject){
        return feedRepository.findAllBySubject(subject);


    }
}
