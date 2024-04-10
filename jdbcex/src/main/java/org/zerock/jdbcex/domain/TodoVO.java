package org.zerock.jdbcex.domain;


// tbl_todo 테이블의 데이터를 자바 객체로 처리하기 위해서 테이블과 유사한 구조의 TodoVO 클래스와 객체를 이용한다.
// Lombok를 사용하면 반복적으로 생성하는 코드를 줄여주기 때문에 DTO나 VO를 작성할 때 편리하다.

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter // VO는 주로 읽기 전용으로 사용하기때문에
@Builder // 객체 생성 시에 빌더 패턴 이용을 위함
@ToString
public class TodoVO {

    // 데이터베이스 내에 생성한 tbl_todo테이블의 칼럼을 기준으로 작성
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
