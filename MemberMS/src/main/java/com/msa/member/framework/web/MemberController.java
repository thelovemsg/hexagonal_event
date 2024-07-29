package com.msa.member.framework.web;

import com.msa.member.application.usecase.AddMemberUsecase;
import com.msa.member.application.usecase.InquiryMemberUsecase;
import com.msa.member.framework.web.dto.MemberInfoDTO;
import com.msa.member.framework.web.dto.MemberOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {
    private final AddMemberUsecase addMemberUsecase;
    private final InquiryMemberUsecase inquiryMemberUsecase;

    @PostMapping("/Member/")
    public ResponseEntity<MemberOutputDTO> addMember(@RequestBody MemberInfoDTO memberInfoDTO) {
        MemberOutputDTO addedMember =
                addMemberUsecase.addMember(memberInfoDTO);
        return new ResponseEntity<>(addedMember, HttpStatus.CREATED);
    }

    @GetMapping("/Member/{no}")
    public ResponseEntity<MemberOutputDTO> getMember(@PathVariable("no") long no) {
        MemberOutputDTO member = inquiryMemberUsecase.getMember(no);
        return member != null
                ? new ResponseEntity<>(member, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}