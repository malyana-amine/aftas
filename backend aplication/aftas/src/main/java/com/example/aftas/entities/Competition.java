package com.example.aftas.entities;

import jakarta.persistence.*;
import lombok.*;


import java.sql.Time;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Competition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date date;
    private Time startTime;
    private Time endTime;
    private Integer numberOfParticipant;
    private String location;
    private Double amount;

    @OneToMany(mappedBy = "competition")
    @ToString.Exclude
    private List<Hunting> hunting;

    @OneToMany(mappedBy = "competition")
    @ToString.Exclude
    private List<Ranking> ranks;
}