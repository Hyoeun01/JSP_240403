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
    private Long tno;

    @NotEmpty // null, 빈 문자열 불가
    private String title;

    @Future // 현재보다 미래인지?
    private LocalDate dueDate;

    private boolean finished;

    @NotEmpty
    private String writer; // 새로 추가됨!
}
