package com.example.demo.dto;

import lombok.Data;

@Data
public class MemberJoinDTO {
    private String mid;
    private String mpw;
    private String name;
    private String email;
    private String addr;
    private boolean del;

}
