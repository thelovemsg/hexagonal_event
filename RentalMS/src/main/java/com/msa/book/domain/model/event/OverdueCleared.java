package com.msa.book.domain.model.event;

import com.msa.book.domain.model.vo.IDName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OverdueCleared {
    private IDName idName;
    private long point;
}
