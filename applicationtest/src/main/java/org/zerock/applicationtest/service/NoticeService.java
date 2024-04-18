package org.zerock.applicationtest.service;


import lombok.extern.log4j.Log4j2;
import org.zerock.applicationtest.dao.NoticeDAO;
import org.zerock.applicationtest.dto.NoticeDTO;

import java.util.List;

@Log4j2
public enum NoticeService {
    INSTANCE;

    private NoticeDAO dao = new NoticeDAO();

    public void addNotice(NoticeDTO noticeDTO) throws Exception {
        log.info("add.....");
        dao.insertNotice(noticeDTO);
    }

    public List<NoticeDTO> listAll() throws Exception{
        return dao.selectAllNotice();
    }

    public NoticeDTO getNotice(int no) throws Exception {
        log.info("no : "+no);
        return dao.selectOneNotice(no);
    }

    public void removeNotice(int no) throws Exception {
        log.info("no : "+no);
        dao.deleteOneNotice(no);
    }
}
