package com.example.aftas.DTO;

import com.example.aftas.entities.embadded.MemberCompetition;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RankingDTO {
    private Long  id;
    private Integer rank;
    private Integer score;
    private Long memberId;
    private Long competitionId;
}
