package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.InquiryMemberUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryMemberInputPort implements InquiryMemberUsecase {

    private final MemberOutputPort memberOutputPort;

    @Override
    public MemberOutputDTO getMember(long memberNo) {
        Member loadMember = memberOutputPort.loadMember(memberNo);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}
