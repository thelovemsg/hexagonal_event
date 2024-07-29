package com.msa.book.application.inputport;

import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.OverdueItemUsecase;
import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.vo.Item;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.UserItemInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class OverdueItemInputPort implements OverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO overdueItem(UserItemInputDTO rental) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(rental.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.overdueItem(new Item(rental.getItemId(), rental.getItemTitle()));
        return  RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
