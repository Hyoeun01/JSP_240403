package org.zerock.b01copy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.zerock.b01copy.domain.Member;
import org.zerock.b01copy.domain.MemberRole;
import org.zerock.b01copy.dto.MemberJoinDTO;
import org.zerock.b01copy.repository.MemberRepository;

import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public void join(MemberJoinDTO memberJoinDTO) throws MidExistException {
        String mid = memberJoinDTO.getMid();
        boolean exist = memberRepository.existsById(mid);
        if(exist) {
            throw new MidExistException();
        }
        Member member = modelMapper.map(memberJoinDTO, Member.class);
        member.changePassword(passwordEncoder.encode(memberJoinDTO.getMpw()));
        member.addRole(MemberRole.USER);

        log.info("---------------");
        log.info(member);
        log.info(member.getRoleSet());

        memberRepository.save(member);
    }

    @Override
    public void modify(MemberJoinDTO memberJoinDTO) {
        Optional<Member> result = memberRepository.findById(memberJoinDTO.getMid());
        Member member = result.orElseThrow();
        member.change(memberJoinDTO.getMpw(), memberJoinDTO.getName(),memberJoinDTO.getEmail(),memberJoinDTO.getAddr());
        member.changePassword(passwordEncoder.encode(memberJoinDTO.getMpw()));
        memberRepository.save(member);
    }



    @Override
    public void remove(MemberJoinDTO memberJoinDTO) {
        String mid = memberJoinDTO.getMid();
        memberRepository.deleteById(mid);
    }

    @Override
    public boolean checker(MemberJoinDTO memberJoinDTO) {
        String mid = memberJoinDTO.getMid();
        boolean exist = memberRepository.existsById(mid);
        return exist;
    }
}
