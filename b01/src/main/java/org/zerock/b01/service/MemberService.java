package org.zerock.b01.service;


import org.zerock.b01.dto.MemberDTO;

public interface MemberService {
    String register(MemberDTO memberDTO);
    MemberDTO readOne(String memberId);

}
