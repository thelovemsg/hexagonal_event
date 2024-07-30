package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.UsePointUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class UsePointInputPort implements UsePointUsecase {

    private final MemberOutputPort memberOutPutPort;

    @Override
    public MemberOutputDTO usePoint(IDName idName, long point) throws
            Exception {
        Member loadMember = memberOutPutPort.loadMemberByIdName(idName);
        loadMember.usePoint(point);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}
