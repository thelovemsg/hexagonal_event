package com.msa.book.framework.web.dto;

import com.msa.book.domain.model.RentalItem;

import java.time.LocalDate;

public record RentItemOutputDTO(Integer itemNo
        , String itemTitle
        , LocalDate rentDate
        , boolean overdued
        , LocalDate overdueDate) {

    public static RentItemOutputDTO mapToDTO(RentalItem rentalItem) {
        return new RentItemOutputDTO(rentalItem.getItem().getNo()
                , rentalItem.getItem().getTitle()
                , rentalItem.getRentDate()
                , rentalItem.isOverdued()
                , rentalItem.getOverdueDate()
        );
    }

}
