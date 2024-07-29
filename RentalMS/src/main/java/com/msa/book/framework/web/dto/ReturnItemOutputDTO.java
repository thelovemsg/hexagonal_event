package com.msa.book.framework.web.dto;

import com.msa.book.domain.model.vo.ReturnItem;

import java.time.LocalDate;

public record ReturnItemOutputDTO(Integer itemNo, String itemTitle, LocalDate returnDate) {
    public static ReturnItemOutputDTO mapToDTO(ReturnItem returnItem) {
        return new ReturnItemOutputDTO(returnItem.getRentalItem().getItem().getNo(), returnItem.getRentalItem().getItem().getTitle(), returnItem.getReturnDate());
    }
}
