package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PageRequestDTO {
    // 목적 > 페이징을 처리하기위해 화면에서 파라미터 정보를 PageRequestDTO 폼에 담아둔다
    // 화면에서 전달한 파라미터를 담아두는 클래스DTO

    @Builder.Default
    @Min(1)
    @Positive
    private int page = 1;


    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    @Positive
    private int size = 10;

    public int getSkip(){
        return (page - 1) * size;
    }

    private String link;

    // 게시글을 눌러서 상세보기(+수정, 삭제 포함)하고 목록을 누르면 1페이지로 돌아가는 것을 해결하기 위한 함수
    public String getLink(){
        if(link==null) {
            StringBuilder builder = new StringBuilder();
            builder.append("page="+this.page);
            builder.append("&size="+this.size);
            link=builder.toString();
        }
        // link = "page=1&size=10" 이런식으로
        return link;
    }
}
