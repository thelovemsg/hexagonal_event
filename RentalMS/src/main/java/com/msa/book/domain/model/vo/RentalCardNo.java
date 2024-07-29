package com.msa.book.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RentalCardNo implements Serializable {
    @Serial
    private static final long serialVersionUID = -21556468746L;
    private String no;

    public static RentalCardNo createRentalCardNo() {
        UUID uuid = UUID.randomUUID();
        String year = String.valueOf(LocalDate.now().getYear());
        String str = year + "-" + uuid;
        return new RentalCardNo(str);
    }

    public static RentalCardNo sample() {
        return RentalCardNo.createRentalCardNo();
    }

    public static void main(String[] args) {
        System.out.println(RentalCardNo.sample());
    }

}
