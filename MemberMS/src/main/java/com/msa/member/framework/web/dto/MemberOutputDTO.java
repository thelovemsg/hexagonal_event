package com.msa.member.framework.web.dto;

import com.msa.member.domain.model.Member;

public record MemberOutputDTO(String id, String name, String password, String email, long point) {
    public static MemberOutputDTO mapToDTO(Member member) {
        return new MemberOutputDTO(member.getIdName().getId()
                                , member.getIdName().getName()
                                , member.getPassword().presentPWD
                                , member.getEmail().address
                                , member.getPoint().pointValue);
    }
}
