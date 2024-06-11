package org.zerock.api01.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class APIUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String mid;
    private String mpw;
    private String name;
    private String email;

    private boolean emailChecked;
    private boolean snsChecked;

    public void changePw(String mpw){
        this.mpw = mpw;
    }
    public void changeName(String name){
        this.name = name;
    }
    public void changeEmail(String email){
        this.email = email;
    }
    public void changeEmailChecked(boolean emailChecked){
        this.emailChecked = emailChecked;
    }
    public void changeSnsChecked(boolean snsChecked){
        this.snsChecked = snsChecked;
    }
}
