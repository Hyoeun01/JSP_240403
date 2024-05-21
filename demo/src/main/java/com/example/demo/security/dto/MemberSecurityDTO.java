package com.example.demo.security.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@Setter
@ToString
public class MemberSecurityDTO extends User {
    // 멤버 변수 설정하기
    private String mid;
    private String mpw;
    private String email;
    private boolean del;
    public MemberSecurityDTO(String username, String password, String email, boolean del) {
        super(username,password,new ArrayList<GrantedAuthority>());
        // 객체안의 멤버 변수에 데이터 설정
        this.mid = username;
        this.mpw = password;
        this.email = email;
        this.del = del;
    }

}
