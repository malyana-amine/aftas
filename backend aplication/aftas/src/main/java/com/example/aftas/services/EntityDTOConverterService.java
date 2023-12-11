package com.example.aftas.services;


import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.entities.Member;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface EntityDTOConverterService {
    List<MemberDTO> convertToDTO(List<Member> member);
    public MemberDTO convertToDTO(Member member);
}
