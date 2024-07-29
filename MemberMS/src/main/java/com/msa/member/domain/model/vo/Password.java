package com.msa.member.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Password {
    public String presentPWD;
    public String pastPWD;
    public static Password sample(){
        return new Password("12345","abcde");
    }
}
