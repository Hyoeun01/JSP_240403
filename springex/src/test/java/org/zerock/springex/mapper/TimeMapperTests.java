package org.zerock.springex.mapper;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class TimeMapperTests {

    // 해당 객체를 주입받지 못해도 예외가 발생하지 않음
    // required=false 옵션이 없으면 timeMapper에 오류가 난다
    @Autowired(required = false)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        log.info(timeMapper.getTime());
    }

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;

    @Test
    public void testNow(){
        log.info(timeMapper2.getNow());
    }
}
