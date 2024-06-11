package org.zerock.api01.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.zerock.api01.dto.APIUserDTO;
import org.zerock.api01.service.APIUserService;

import java.util.Map;

@RestController
@RequestMapping("/api/member")
@Log4j2
@RequiredArgsConstructor
public class APIUserController {
    private final APIUserService apiUserService;

    @PostMapping (value = "/join")
    public Map<String, String> memberJoin(@RequestBody APIUserDTO apiUserDTO) {
        log.info(apiUserDTO);
        String mid = apiUserService.joinMember(apiUserDTO);
        return Map.of("mid", mid);
    }

    @GetMapping("/{mid}")
    public APIUserDTO memberRead(@PathVariable("mid") String mid){
        log.info("memberRead mid : " + mid);
        return apiUserService.memberRead(mid);
    }

    @DeleteMapping(value = "/{mid}")
    public Map<String, String> memberRemove(@PathVariable String mid){
        apiUserService.memberRemove(mid);
        return Map.of("result", "success");
    }

    @PutMapping(value = "/{mid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, String> memberModify(@PathVariable("mid") String mid, @RequestBody APIUserDTO apiUserDTO){
        apiUserDTO.setMid(mid);
        apiUserService.memberModify(apiUserDTO);
        return Map.of("result", "success");
    }
}
