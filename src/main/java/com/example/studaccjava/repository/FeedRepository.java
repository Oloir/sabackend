package com.example.studaccjava.repository;

import com.example.studaccjava.model.Feed;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedRepository extends JpaRepository <Feed, Long> {

    List<Feed> findAllBySubject (int subject);
}
