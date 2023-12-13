package com.example.aftas.services;


import com.example.aftas.DTO.*;
import com.example.aftas.entities.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EntityDTOConverterService {
    List<MemberDTO> convertToDTO(List<Member> member);
    public MemberDTO convertToDTO(Member member);

    public CompetitionDTO convertToDTO(Competition competition);

    RankingDTO convertToDTO(Ranking ranking);

    HuntingDTO convertToDTO(Hunting hunting);

    FishDTO convertToDTO(Fish fish);
}
