package org.zerock.bookmarket.dto;

import lombok.*;

import java.time.LocalDateTime;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberID;
    private String memberPW;
    private String memberName;
    private String phone;
    private String address;
    private String email;
    private LocalDateTime createDate;
}
