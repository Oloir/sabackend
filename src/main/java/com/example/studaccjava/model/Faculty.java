package com.example.studaccjava.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "faculty", schema="social")

public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "faculty_id")
    private long id;

    @Column(name = "faculty_name")
    private String name;
    @Column(name = "faculty_moderated")
    private boolean moderated;
    @Column(name = "faculty_type")
    private int fac_type;


}
