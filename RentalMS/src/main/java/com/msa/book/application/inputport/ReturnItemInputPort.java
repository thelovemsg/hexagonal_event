package com.msa.book.application.inputport;

import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.ReturnItemUsecase;
import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.vo.Item;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.UserItemInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class ReturnItemInputPort implements ReturnItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    @Override
    public RentalCardOutputDTO returnItem(UserItemInputDTO returnDto) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(returnDto.userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        Item returnItem = new Item(returnDto.getItemId(), returnDto.getItemTitle());
        rentalCard.returnItem(returnItem, LocalDate.now());
        return RentalCardOutputDTO.mapToDTO(rentalCard);
    }
}
