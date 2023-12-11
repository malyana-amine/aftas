package com.example.aftas.services;


import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.entities.Member;
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
}

