package com.example.aftas.services.Member;

import com.example.aftas.entities.Member;
import com.example.aftas.repositories.MemberRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Component
public class MemberServiceImp implements MemberService{


    private MemberRepository memberRepository;


    public MemberServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Override
    public Optional<Member> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Member save(Member member) {
        LocalDate currentDate = LocalDate.now();
        Date now = java.sql.Date.valueOf(currentDate); // Convert to java.util.Date
        member.setAccessionDate(now);
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member entityDTO) {
        return null;
    }

    @Override
    public Optional<Member> delete(Long aLong) {
        return Optional.empty();
    }
}
