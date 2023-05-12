package com.lec.ch04_member.service;

import com.lec.ch04_member.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MemberServiceTest {
    MemberService memberService
            = new MemberService(new MemberRepositoryImpl());
    @BeforeEach
    void beforeEach(){
        memberService.clearStore();
    }
    @Test
    void 회원가입() {
    }
}