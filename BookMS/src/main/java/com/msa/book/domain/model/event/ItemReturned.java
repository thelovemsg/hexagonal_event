package com.msa.book.domain.model.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ItemReturned extends ItemRented {
    public ItemReturned(IDName idName, Item item, long point) {
        super(idName, item, point);
    }
}
