package org.zerock.b01copy.service;

import org.zerock.b01copy.dto.MemberJoinDTO;

public interface MemberService {
    static class MidExistException extends Exception{
    }
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
    void modify(MemberJoinDTO memberJoinDTO);
    void remove(MemberJoinDTO memberJoinDTO);
}
