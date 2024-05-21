package com.example.demo.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Member extends BaseEntity{
    @Id
    private String mid;

    private String mpw;
    private String email;
    private boolean del;

    public void changePassword(String mpw){
        this.mpw=mpw;
    }
    public void changeEmail(String email){
        this.email=email;
    }
    public void changeDel(boolean del){
        this.del=del;
    }

}
