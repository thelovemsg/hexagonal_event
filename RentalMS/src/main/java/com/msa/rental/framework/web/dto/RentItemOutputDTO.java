package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
