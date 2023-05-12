package com.lec.ch04_member.service;

import com.lec.ch04_member.model.Member;
import com.lec.ch04_member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    public int join(Member member){
        memberRepository.save(member);
        return member.getNo();
    }
}
