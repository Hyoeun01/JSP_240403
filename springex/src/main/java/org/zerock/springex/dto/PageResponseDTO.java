package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString

public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    // 시작 페이지 번호
    private int start;

    // 종료 페이지 번호
    private int end;

    // 이전 페이지 존재 여부
    private boolean prev;
    // 다음 페이지 존재 여부
    private boolean next;

    // dtoList로 받기
    private List<E> dtoList;


    @Builder(builderMethodName = "withAll")
    // 생성자 만들기( 파라미터 3개짜리)
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;

        // end 페이지 계산후 start 페이지 계산
        this.end = (int)(Math.ceil(this.page/10.0)) * 10;

        // 시작 페이지 구하기
        this.start = this.end - 9;

        // last 생성후 end멤버에 재사용하기
        int last = (int)(Math.ceil((total / (double) size)));

        // end와 last를 비교해서 last틀 출력할지 end를 출력할지 결정
        this.end = end > last ? last : end;

        // prev 존재유무
        this.prev = this.start >1;

        // next 존재유무
        this.next = total > this.end * this.size;
    }
}
