package org.zerock.api01.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.zerock.api01.domain.APIUser;
import org.zerock.api01.dto.APIUserDTO;
import org.zerock.api01.repository.APIUserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class APIUserServiceImpl implements APIUserService{

    private final APIUserRepository apiUserRepository;
    private final ModelMapper modelMapper;

    @Override
    public String joinMember(APIUserDTO apiUserDTO) {
        APIUser apiUser = modelMapper.map(apiUserDTO, APIUser.class);
        String mid = apiUserRepository.save(apiUser).getMid();
        return mid;
    }

    @Override
    public APIUserDTO memberRead(String mid) {
        Optional<APIUser> result = apiUserRepository.findById(mid);
        APIUser apiUser = result.orElseThrow();
        return modelMapper.map(apiUser, APIUserDTO.class);
    }

    @Override
    public void memberRemove(String mid) {
        apiUserRepository.deleteById(mid);
    }

    @Override
    public void memberModify(APIUserDTO apiUserDTO) {
        Optional<APIUser> result = apiUserRepository.findById(apiUserDTO.getMid());
        APIUser apiUser = result.orElseThrow();
        apiUser.changePw(apiUserDTO.getPassword());
        apiUser.changeName(apiUserDTO.getName());
        apiUser.changeEmail(apiUserDTO.getEmail());
        apiUser.changeEmailChecked(apiUserDTO.isEmailChecked());
        apiUser.changeSnsChecked(apiUserDTO.isSnsChecked());
        apiUserRepository.save(apiUser);

    }
}
