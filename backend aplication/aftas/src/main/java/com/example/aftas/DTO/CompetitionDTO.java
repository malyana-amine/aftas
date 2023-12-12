package com.example.aftas.DTO;

import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Ranking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompetitionDTO {
    private Long id;
    private Date date;
    private Time startTime;
    private Time endTime;
    private Integer numberOfParticipant;
    private String location;
    private Double amount;
    private List<Hunting> hunting;
    private List<Ranking> ranks;
}
