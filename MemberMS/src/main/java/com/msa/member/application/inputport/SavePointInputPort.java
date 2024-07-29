package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.SavePointUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SavePointInputPort implements SavePointUsecase {

    private final MemberOutputPort memberOutputPort;


    @Override
    public MemberOutputDTO savePoint(IDName idName, Long point) {
        Member loadMember = memberOutputPort.loadMemberByIdName(idName);
        loadMember.savePoint(point);
        return MemberOutputDTO.mapToDTO(loadMember);
    }
}
