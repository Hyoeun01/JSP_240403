package org.zerock.b01.repsitory;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.Reply;
import org.zerock.b01.repository.ReplyRepository;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert(){
        Long bno = 100L; // 실제로 존재하는 bno를 넣어야함

        // Reply 클래스에 멤버로 사용될 더미 예제
        Board board = Board.builder().bno(bno).build();

        // Reply 클래스 생성하기
        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글..........")
                .replyer("replyer1").build();

        // 저장하기
        replyRepository.save(reply);

    }
}
