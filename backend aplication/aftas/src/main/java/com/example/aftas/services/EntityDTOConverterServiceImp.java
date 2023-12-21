package com.example.aftas.services;


import com.example.aftas.DTO.*;
import com.example.aftas.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    @Override
    public List<FishDTO> convertTofishDTO(List<Fish> fish) {
        return fish.stream()
                .map(fishes -> modelMapper.map(fishes, FishDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public List<CompetitionDTO> convertToDTO1(List<Competition> competitions){
        return competitions.stream()
                .map(competition -> modelMapper.map(competition, CompetitionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CompetitionDTO> convertToDTO2(Page<Competition> competitions, Pageable pe){
        return new PageImpl<>(competitions.stream()
                .map(competition -> modelMapper.map(competition, CompetitionDTO.class))
                .collect(Collectors.toList()),pe,competitions.getTotalElements());
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
    @Override
    public FishDTO convertToDTO(Fish fish) {
        return modelMapper.map(fish, FishDTO.class);
    }
}

