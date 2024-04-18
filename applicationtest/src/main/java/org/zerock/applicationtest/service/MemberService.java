package org.zerock.applicationtest.service;

import org.zerock.applicationtest.dao.MemberDAO;
import org.zerock.applicationtest.dto.MemberDTO;

public enum MemberService {
    INSTANCE;
    private MemberDAO memberDAO = new MemberDAO();
    public void addMember(MemberDTO memberDTO) throws Exception{
        memberDAO.insertMember(memberDTO);
    }
}
