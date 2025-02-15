package com.msa.member.application.outputport;

import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.IDName;

public interface MemberOutputPort {
    Member loadMember(long memberNo);
    Member loadMemberByIdName(IDName idName);
    Member saveMember(Member member);
}
