package com.msa.book.domain.model.vo;

import com.msa.book.domain.model.RentalItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReturnItem {

    @Embedded
    private RentalItem rentalItem;
    private LocalDate returnDate;

    public static ReturnItem createReturnItem(RentalItem rentalItem) {
        return new ReturnItem(rentalItem, LocalDate.now());
    }

    private static ReturnItem sample() {
        return ReturnItem.createReturnItem(RentalItem.sample());
    }

}
