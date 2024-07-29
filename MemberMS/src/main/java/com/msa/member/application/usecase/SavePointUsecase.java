package com.msa.member.application.usecase;

import com.msa.member.domain.model.vo.IDName;
import com.msa.member.framework.web.dto.MemberOutputDTO;

public interface SavePointUsecase {
    MemberOutputDTO savePoint(IDName idName, Long point);
}
