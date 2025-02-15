package com.msa.book.framework.web.dto;

import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RentalCardOutputDTO {
    private String rentalCardId;
    private String memberId;
    private String memberName;

    private String rentStatus; //대여가능여부
    private Long totalLateFee; //전체연체료
    private Long totalRentalCnt; //전체대여도서건수
    private Long totalReturnCnt; //반납도서건수
    private Long totalOverduedCnt; //연체중인도서건수

    public static RentalCardOutputDTO mapToDTO(RentalCard rental){
        RentalCardOutputDTO rentDTO = new RentalCardOutputDTO();
        rentDTO.setRentalCardId(rental.getRentalCardNo().getNo());
        rentDTO.setMemberId(rental.getMember().getId());
        rentDTO.setMemberName(rental.getMember().getName());
        rentDTO.setRentStatus(rental.getRentStatus().toString());
        rentDTO.setTotalRentalCnt((long) rental.getRentalItemList().size());
        rentDTO.setTotalReturnCnt((long) rental.getReturnItemList().size());
        rentDTO.setTotalOverduedCnt(rental.getRentalItemList().stream().filter(RentalItem::isOverdued).count());
        return rentDTO;
    }
}
