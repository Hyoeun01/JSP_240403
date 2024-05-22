package org.zerock.b01copy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.zerock.b01copy.dto.MemberJoinDTO;
import org.zerock.b01copy.repository.MemberRepository;

public interface MemberService {

    static class MidExistException extends Exception{
    }
    void join(MemberJoinDTO memberJoinDTO) throws MidExistException;
    void modify(MemberJoinDTO memberJoinDTO);
    void remove(MemberJoinDTO memberJoinDTO);
    boolean checker(MemberJoinDTO memberJoinDTO);


}
