package com.msa.book.application.outputport;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.msa.book.domain.model.event.ItemRented;
import com.msa.book.domain.model.event.ItemReturned;
import com.msa.book.domain.model.event.OverdueCleared;

public interface EventOutputPort {
    void occurRentalEvent(ItemRented rentalItemEvent) throws JsonProcessingException;
    void occurReturnEvent(ItemReturned itemReturnedEvent) throws JsonProcessingException;
    void occurOverdueClearedEvent(OverdueCleared overdueCleared) throws JsonProcessingException;
}
