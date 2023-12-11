package com.example.aftas.entities;


import jakarta.persistence.*;
import lombok.*;



@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Fish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private Double averageWeight;

    @ManyToOne
    private Level level;
}