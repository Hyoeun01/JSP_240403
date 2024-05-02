package org.zerock.bookmarket.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.bookmarket.domain.MemberVO;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MemberMapperTests {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void testInsert(){
        MemberVO memberVO = MemberVO.builder()
                .memberID("test1")
                .memberPW("1234")
                .memberName("testUser")
                .phone("010-1234-1234")
                .email("test1@naver.com")
                .build();

        memberMapper.insert(memberVO);
    }

}
