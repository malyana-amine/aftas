package com.example.aftas.DTO;


import com.example.aftas.entities.Level;
import lombok.*;


@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FishDTO {
    private Long id;
    private String name;
    private Double averageWeight;
    private Level level;
}