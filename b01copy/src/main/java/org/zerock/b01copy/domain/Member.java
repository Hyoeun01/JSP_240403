package org.zerock.b01copy.domain;

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
@ToString(exclude = "roleSet")
public class Member extends BaseEntity{
    @Id
    private String mid;

    private String mpw;
    private String name;
    private String email;
    private String addr;
    private boolean del;

    private boolean social;
public void change(String mpw, String name, String email, String addr){
    this.mpw=mpw;
    this.name = name;
    this.email=email;
    this.addr=addr;
}

    @ElementCollection(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<MemberRole> roleSet = new HashSet<>();

    public void changePassword(String mpw){
        this.mpw=mpw;
    }
    public void changeEmail(String email){
        this.email=email;
    }
    public void changeDel(boolean del){
        this.del=del;
    }
    public void changeSocial(boolean social){
        this.social=social;
    }
    public void addRole(MemberRole memberRole){
        this.roleSet.add(memberRole);
    }

    public void clearRoles(){
        this.roleSet.clear();
    }
}
