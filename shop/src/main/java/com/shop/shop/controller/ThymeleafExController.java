package com.shop.shop.controller;

import com.shop.shop.dto.ItemDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
// url에 "/thymeleaf"경로로 오는 요청을 ThymeleafExController 가 처리
@RequestMapping(value = "/thymeleaf")
public class ThymeleafExController {
    @GetMapping(value = "/ex01")
    public String thymeleafExample01(Model model){
        model.addAttribute("data","타임리프 예제");
        return "thymeleafEx/thymeleafEx01";
    }

    @GetMapping(value = "/ex02")
    public String thymeleafExample02(Model model){
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setItemDetail("상품 상세 설명");
        itemDTO.setItemNm("테스트 상품 1");
        itemDTO.setPrice(10000);
        itemDTO.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto",itemDTO);
        return "thymeleafEx/thymeleafEx02";
    }
}
