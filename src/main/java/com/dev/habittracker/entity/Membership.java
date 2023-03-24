package com.dev.habittracker.entity;

import jakarta.persistence.*;

//Idk if theres a difference in naming the package Entity or model
@Entity
@Table(name = "membership")
public class Membership {

/*    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//do i need this*/

    @OneToMany
    @JoinColumn(name = "user_id")
    @Id
    private User user;

    @Column(name = "status")
    private boolean status; //false is no membership true is membership



}
