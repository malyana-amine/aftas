package com.example.aftas.services;


import com.example.aftas.DTO.CompetitionDTO;
import com.example.aftas.DTO.HuntingDTO;
import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.DTO.RankingDTO;
import com.example.aftas.entities.Competition;
import com.example.aftas.entities.Hunting;
import com.example.aftas.entities.Member;
import com.example.aftas.entities.Ranking;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
@Qualifier("entityDTOConverterService")
public class EntityDTOConverterServiceImp implements EntityDTOConverterService {
    private final ModelMapper modelMapper;

    public EntityDTOConverterServiceImp(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<MemberDTO> convertToDTO(List<Member> members) {
        return members.stream()
                .map(member -> modelMapper.map(member, MemberDTO.class))
                .collect(Collectors.toList());
    }
    {

    }
    public MemberDTO convertToDTO(Member member) {
        return modelMapper.map(member, MemberDTO.class);
    }

    @Override
    public CompetitionDTO convertToDTO(Competition competition) {
        return modelMapper.map(competition, CompetitionDTO.class);
    }
    @Override
    public RankingDTO convertToDTO(Ranking ranking) {
        return modelMapper.map(ranking, RankingDTO.class);
    }
    @Override
    public HuntingDTO convertToDTO(Hunting hunting) {
        return modelMapper.map(hunting, HuntingDTO.class);
    }
}

