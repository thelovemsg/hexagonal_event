package com.msa.rental.domain.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class LateFee {
    private long point;

    public LateFee addPoint(long point) {
        return new LateFee(this.point + point);
    }

    public LateFee removePoint(long point) throws Exception {
        if (this.point > point){
            throw new Exception("보유한 포인트보다 커서 삭제가 불가능");
        }
        return new LateFee(this.point - point);
    }

    public static LateFee createLateFee() {
        return new LateFee(0);
    }

    public static LateFee sample() {
        return new LateFee(100);
    }

}
