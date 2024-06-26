package org.zerock.api01.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
    @Tag(name="샘플 테스트",description = "테스트중")
    @GetMapping("/doA")
    public List<String> doA(){
        return Arrays.asList("aaa","bbb","ccc");
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/doB")
    public List<String> doB(){
        return Arrays.asList("Admin aaa","Admin bbb","Admin ccc");
    }
}
