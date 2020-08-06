package com.example.lecture.service;

import com.example.lecture.entity.Member;
import com.example.lecture.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void join(Member member) throws Exception {
        memberRepository.create(member);
    }
}
