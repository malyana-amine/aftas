package com.example.aftas.services.Member;

import com.example.aftas.entities.Member;
import com.example.aftas.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface MemberService extends CrudService<Member, Long> {
}
