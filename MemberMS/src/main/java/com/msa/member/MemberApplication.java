package com.msa.member;

import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.Email;
import com.msa.member.domain.model.vo.IDName;
import com.msa.member.domain.model.vo.Password;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MemberApplication {

    public static void main(String[] args) throws Exception {
        domainTest();
        SpringApplication.run(MemberApplication.class, args);
    }

    public static void domainTest() throws Exception {
        System.out.println("------------도메인 모델 테스트 진행------------");
        System.out.println("회원 생성");
        var member = Member.registerMember(IDName.sample(), Password.sample(), Email.sample());
        System.out.println(member.toString());
        System.out.println("포인트 10 적립");
        member.savePoint(10L);
        System.out.println(member.getPoint());
        System.out.println("포인트 20 적립");
        member.savePoint(20L);
        System.out.println(member.getPoint());
        System.out.println("포인트 10 사용");
        member.usePoint(10L);
        System.out.println(member.getPoint());
        System.out.println("-----------------------------------------");
    }

}
