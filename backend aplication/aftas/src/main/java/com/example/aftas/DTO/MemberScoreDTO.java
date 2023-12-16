package com.example.aftas.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberScoreDTO {
    private Long memberId;
    private String memberName;
    private Double score;
}
