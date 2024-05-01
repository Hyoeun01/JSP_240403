package org.zerock.b01.repsitory;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.Member;
import org.zerock.b01.repository.MemberRepository;

import java.time.LocalDateTime;

@SpringBootTest
@Log4j2
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void testInsert(){
        Member member = Member.builder()
                .member_id("test3")
                .member_pw("1234")
                .name("testuser1")
                .phone("010-1234-5678")
                .email1("test")
                .email2("naver.com")
                .gender("male")
                .agree(true)
                .build();

        Member result = memberRepository.save(member);
    }
}
