package com.msa.book.domain.model.event;

import com.msa.book.domain.model.vo.IDName;
import com.msa.book.domain.model.vo.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class ItemRented implements Serializable {
    private IDName idName;
    private Item item;
    private long point;
}
