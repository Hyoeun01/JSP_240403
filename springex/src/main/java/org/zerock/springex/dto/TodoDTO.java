package org.zerock.springex.dto;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TodoDTO {

    // DTO (Data Transfer Object) : 프레이젠테이션 계층 >> 보여주기
    // 실제 DB에 존재하는 정보보다 적은 양의 정보를 골라서 사용 가능하게 하기
    private Long tno;

    @NotEmpty // null, 빈 문자열 불가
    private String title;

    @Future // 현재보다 미래인지?
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer; // 새로 추가됨!
}
