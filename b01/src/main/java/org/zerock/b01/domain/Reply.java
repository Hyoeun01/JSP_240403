package org.zerock.b01.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "board")
public class Reply extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 댓글번호, 자동 증가(오토 인크리먼트)
    private Long rno;

    // (Reply : Many) -> To (Board : One) : 단방향 참조
    // 장점 : 설정이 쉽고 간단함
    // 단점 : 서로간 참조가 어려움 >> 조인 설정을 이용하면 해소가 가능하다
    // FetchType.LAZY : DB에 연결을 즉시x 늦게 하겠다
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    private String replyText;

    private String replyer;
}
