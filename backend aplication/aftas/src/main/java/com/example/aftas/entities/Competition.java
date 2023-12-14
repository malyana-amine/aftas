package com.example.aftas.entities;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.text.SimpleDateFormat;
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
    private String code;

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

    public void generateCode() {
        if (location != null && date != null) {
            String locationCode = location.length() >= 3 ? location.substring(0, 3).toUpperCase() : location.toUpperCase();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            String datePart = dateFormat.format(date);
            this.code = locationCode + "-" + datePart;
        } else {
            // Handle the case when either location or date is null
            throw new IllegalArgumentException("Location and date must be set before generating the code");
        }
    }
}
