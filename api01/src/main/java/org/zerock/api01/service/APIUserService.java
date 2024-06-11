package org.zerock.api01.service;

import jakarta.transaction.Transactional;
import org.zerock.api01.dto.APIUserDTO;

@Transactional
public interface APIUserService {
    String joinMember(APIUserDTO apiUserDTO);
    APIUserDTO memberRead(String mid);
    void memberRemove(String mid);
    void memberModify(APIUserDTO apiUserDTO);

}
