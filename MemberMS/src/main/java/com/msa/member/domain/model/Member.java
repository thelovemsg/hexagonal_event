package com.msa.member.domain.model;

import com.msa.member.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long MemberNo;
    @Embedded
    private IDName idName;
    @Embedded
    private Password password;
    @Embedded
    private Email email;
    @ElementCollection
    private List<Authority> authorities = new ArrayList<>();
    @Embedded
    private Point point;

    public static Member registerMember(IDName idName, Password password, Email email) {
        Member member = new Member();
        member.setIdName(idName);
        member.setPassword(password);
        member.setEmail(email);
        member.setPoint(new Point(0L));
        member.addAuthorities(new Authority(UserRole.USER)); // AList.of(new Authority(UserRole.USER)));
        return member;

    }

    private void addAuthorities(Authority authority) {
        this.authorities.add(authority);
    }

    public void savePoint(Long point) {
        this.point.addPoint(point);
    }

    public void usePoint(Long point) throws Exception {
        this.point.removePoint(point);
    }
}