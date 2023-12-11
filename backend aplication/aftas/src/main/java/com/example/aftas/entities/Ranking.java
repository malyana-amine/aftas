package com.example.aftas.entities;


import com.example.aftas.entities.embadded.MemberCompetition;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ranking {

    @EmbeddedId
    private MemberCompetition id;

    private Integer rank;
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @MapsId("memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_id")
    @MapsId("competitionId")
    private Competition competition;
}