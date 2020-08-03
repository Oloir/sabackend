package com.example.studaccjava.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "router", schema = "social")
public class Router {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "router_id")
    private long id;

    @Column (name = "type_id")
    private int type;

    @Column (name = "item_id")
    private int item;
}
