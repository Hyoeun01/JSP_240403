package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.MemberDTO;

@SpringBootTest
@Log4j2
public class MemberServiceTests {
    @Autowired
    private MemberService memberService;

    @Test
    public void testReadOne(){
        String memberID = "test4";
        MemberDTO memberDTO = memberService.readOne(memberID);

        log.info("memberID : {}", memberDTO.getMember_id());
        log.info("memberPW : {}", memberDTO.getMember_pw());

    }
}
