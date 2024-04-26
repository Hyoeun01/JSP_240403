package org.zerock.b01.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NoticeDTO {
    private Long no;
    private String title;
    private String content;

    @Builder.Default
    private Long count = 0L;
    private LocalDateTime regDate;
    private LocalDateTime modDate;
}