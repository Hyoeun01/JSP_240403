package org.zerock.b01.repsitory;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.b01.domain.Board;
import org.zerock.b01.domain.Reply;
import org.zerock.b01.repository.BoardRepository;
import org.zerock.b01.repository.ReplyRepository;

import java.util.UUID;

@SpringBootTest
@Log4j2
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){
        // 게시글번호가 100번
        Long bno = 100L;

        // Reply 클래스에 멤버로 사용될 더미 예제
        Board board = Board.builder().bno(bno).build();

        // Reply 클래스 생성하기
        Reply reply = Reply.builder()
                .board(board)
                .replyText("댓글4..........")
                .replyer("replyer4").build();

        // 저장하기
        replyRepository.save(reply);
    }

    // 댓글 페이징 처리 조회 리스트
    @Transactional
    @Test
    public void testBoardReplies() {
        // 이 번호의 게시글의 댓글 목록을 페이징 처리해서 조회함
        Long bno = 100L;
        Pageable pageable = PageRequest.of(0, 10, Sort.by("rno").descending());

        Page<Reply> result = replyRepository.listOfBoard(bno, pageable);

        result.getContent().forEach(reply -> {
            log.info(reply);
        });
    }

    @Test
    public void testInsertWithImages(){
        Board board = Board.builder()
                .title("이미지테스트")
                .content("첨부파일 테스트")
                .writer("tester")
                .build();

        for (int i = 0 ; i < 3 ; i ++) {
            board.addImage(UUID.randomUUID().toString(),"file"+i+".jpg");
        } // end for

        boardRepository.save(board);
    }
}
