package com.example.studaccjava.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "feed", schema = "social")

public class Feed  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feed_id")
    private long id;

    @Column(name = "feed_author")
    private int author;

    @Column(name = "feed_text")
    private String text;

    @Column(name = "rate")
    private int rate;

    @Column(name = "feed_subject")
    private int subject;


}
