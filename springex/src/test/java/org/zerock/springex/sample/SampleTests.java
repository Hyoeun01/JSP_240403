package org.zerock.springex.sample;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;


@Log4j2
@ExtendWith(SpringExtension.class) // JUnit5버전에서 spring-test 이용하기위함. (JUnit4버전은 @Runwith)
@ContextConfiguration(locations ="file:src/main/webapp/WEB-INF/root-context.xml") // 스프링의 설정 정보 로딩. 지금은 XML 설정이므로 locations를 이용하고 자바 설정의 경우 classes 속성 이용
public class SampleTests {

    // 스프링에서 사용하는 의존성 주입관련 어노테이션. 만일 해당타입의 빈이 존재하면 여기에 주입해주세요
    @Autowired
    private SampleService sampleService;

    @Autowired
    private DataSource dataSource;

    @Test
    public void testService1() {
        // 실행시 스프링에서 생성하고 관리하는 객체 확인가능
        log.info(sampleService);
        Assertions.assertNotNull(sampleService);
    }

    @Test
    public void testConnection() throws Exception {
        Connection conn = dataSource.getConnection();
        log.info(conn);
        Assertions.assertNotNull(conn);

        conn.close();
    }
}
