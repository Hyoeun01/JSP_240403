package org.zerock.b01.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.b01.dto.BoardDTO;

@SpringBootTest
@Log4j2
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){
        log.info(boardService.getClass().getName());

        BoardDTO boardDTO = BoardDTO.builder()
                .title("sample title........")
                .content("sample content,,,")
                .writer("user123")
                .build();

        Long bno = boardService.register(boardDTO);
        log.info("bno : " +bno);
    }

@Test
    public void testModify(){
        //변경에 필요한 데이터만
    BoardDTO boardDTO = BoardDTO.builder()
            .bno(201L)
            .title("update title")
            .content("update content")
            .build();
    boardService.modify(boardDTO);
}


}
