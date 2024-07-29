package com.msa.member.application.inputport;

import com.msa.member.application.outputport.MemberOutputPort;
import com.msa.member.application.usecase.AddMemberUsecase;
import com.msa.member.domain.model.Member;
import com.msa.member.domain.model.vo.Email;
import com.msa.member.domain.model.vo.IDName;
import com.msa.member.domain.model.vo.Password;
import com.msa.member.framework.web.dto.MemberInfoDTO;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddMemberInputPort implements AddMemberUsecase {

    private final MemberOutputPort memberOutputPort;

    @Override
    public MemberOutputDTO addMember(MemberInfoDTO memberInfoDTO) {
        IDName idName = new IDName(memberInfoDTO.id(), memberInfoDTO.name());
        Password pwd = new Password(memberInfoDTO.password(), memberInfoDTO.password());
        Email email = new Email(memberInfoDTO.email());
        Member addedMember = Member.registerMember(idName, pwd, email);
        Member savedMember = memberOutputPort.saveMember(addedMember);
        return MemberOutputDTO.mapToDTO(savedMember);
    }
}
