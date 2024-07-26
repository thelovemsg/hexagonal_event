package com.msa.rental.framework.web.dto;

import com.msa.rental.domain.model.vo.ReturnItem;

import java.time.LocalDate;

public record ReturnItemOutputDTO(Integer itemNo, String itemTitle, LocalDate returnDate) {
    public static ReturnItemOutputDTO mapToDTO(ReturnItem returnItem) {
        return new ReturnItemOutputDTO(returnItem.getRentalItem().getItem().getNo(), returnItem.getRentalItem().getItem().getTitle(), returnItem.getReturnDate());
    }
}
