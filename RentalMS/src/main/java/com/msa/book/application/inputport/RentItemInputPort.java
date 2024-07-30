package com.msa.book.application.inputport;

import com.msa.book.application.outputport.EventOutputPort;
import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.RentItemUsecase;
import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.event.ItemRented;
import com.msa.book.domain.model.vo.IDName;
import com.msa.book.domain.model.vo.Item;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.UserItemInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class RentItemInputPort implements RentItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalCardOutputDTO rentItem(UserItemInputDTO rental) {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.userId)
                .orElseGet(() -> RentalCard.createRentalCard(new IDName(rental.getUserId(), rental.getUserNm())));

        Item newItem = new Item(rental.getItemId(), rental.getItemTitle());
        rentalCard.rentItem(newItem);
        //대여 이벤트 생성 및 발행
        ItemRented itemRentedEvent = RentalCard.createItemRentedEvent(rentalCard.getMember(), newItem, 10L);
        eventOutputPort.occurRentalEvent(itemRentedEvent);

        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
