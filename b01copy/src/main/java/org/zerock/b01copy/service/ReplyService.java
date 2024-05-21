package org.zerock.b01copy.service;

import org.zerock.b01copy.dto.PageRequestDTO;
import org.zerock.b01copy.dto.PageResponseDTO;
import org.zerock.b01copy.dto.ReplyDTO;

public interface ReplyService {
    Long register(ReplyDTO replyDTO);
    ReplyDTO read(Long rno);
    void modify(ReplyDTO replyDTO);
    void remove(Long rno);

    PageResponseDTO<ReplyDTO> getListOfBoard(Long bno, PageRequestDTO pageRequestDTO);
}
