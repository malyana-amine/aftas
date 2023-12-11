package com.example.aftas.web.rest;

import com.example.aftas.DTO.MemberDTO;
import com.example.aftas.entities.Member;
import com.example.aftas.services.EntityDTOConverterService;
import com.example.aftas.services.EntityDTOConverterServiceImp;
import com.example.aftas.services.Member.MemberService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberRest {
    private MemberService memberService;
    private EntityDTOConverterService converterService;

    public MemberRest(MemberService memberService, @Qualifier("entityDTOConverterService") EntityDTOConverterService converterService) {
        this.memberService = memberService;
        this.converterService = converterService;
    }

    @GetMapping("")
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        List<Member> members = memberService.findAll();
        List<MemberDTO> memberDTOs = converterService.convertToDTO(members);
        return new ResponseEntity<>(memberDTOs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MemberDTO> saveMember(@RequestBody Member member1){
        Member member = memberService.save(member1);
        MemberDTO memberDTO = converterService.convertToDTO(member);
        return new ResponseEntity<>(memberDTO, HttpStatus.OK);
    }


}

