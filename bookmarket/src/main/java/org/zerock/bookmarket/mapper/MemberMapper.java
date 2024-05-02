package org.zerock.bookmarket.mapper;

import org.zerock.bookmarket.domain.MemberVO;
import org.zerock.bookmarket.dto.MemberDTO;

public interface MemberMapper {
    void insert(MemberVO memberVO);
    MemberVO login(MemberVO memberVO);
}
