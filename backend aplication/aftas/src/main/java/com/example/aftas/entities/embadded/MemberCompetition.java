package com.example.aftas.entities.embadded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberCompetition implements Serializable {
    @Column(name = "member_id")
    private Long memberId;
    @Column(name = "competition_id")
    private Long competitionId;


}
