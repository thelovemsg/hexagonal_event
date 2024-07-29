package com.msa.book.application.inputport;

import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.CreateRentalCardUsecase;
import com.msa.book.domain.model.RentalCard;
import com.msa.book.domain.model.vo.IDName;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateRentalCardInputPort implements CreateRentalCardUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public RentalCardOutputDTO createRentalCard(UserInputDTO userInputDTO) {
        RentalCard rentalCard = RentalCard.createRentalCard(new IDName(userInputDTO.getUserId(), userInputDTO.getUserNm()));
        RentalCard save = rentalCardOutputPort.save(rentalCard);
        return RentalCardOutputDTO.mapToDTO(save);
    }
}
