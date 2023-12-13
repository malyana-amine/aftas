package com.example.aftas.services;


import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.HuntingDTO;
import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EntityDTOConverterService {
    List<MemberDTO> convertToDTO(List<Member> member);
    public MemberDTO convertToDTO(Member member);

    public CompetitionDTO convertToDTO(Competition competition);

    RankingDTO convertToDTO(Ranking ranking);

    HuntingDTO convertToDTO(Hunting hunting);
}
