package org.zerock.bookmarket.service;

import org.zerock.bookmarket.dto.MemberDTO;

public interface MemberService {
    void join(MemberDTO memberDTO);
    MemberDTO login(MemberDTO memberDTO)  throws Exception;
}
