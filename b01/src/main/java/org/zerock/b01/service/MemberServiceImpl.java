package org.zerock.b01.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.b01.dto.MemberDTO;
import org.zerock.b01.repository.MemberRepository;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService{
    private final ModelMapper modelMapper;
    private final MemberRepository memberRepository;

    @Override
    public String register(MemberDTO memberDTO) {
        return "";
    }

    @Override
    public MemberDTO readOne(String memberId) {
        return null;
    }
    //    @Override
//    public String register(MemberDTO memberDTO) {
//        Member member = modelMapper.map(memberDTO, Member.class);
//        Member memberID = memberRepository.save(member);
//        return member.getMember_id();
//    }
//
//    @Override
//    public MemberDTO readOne(String memberId) {
//        Optional<Member> result = memberRepository.findById(memberId);
//        Member member = result.orElseThrow();
//
//        return null;
//    }
}
