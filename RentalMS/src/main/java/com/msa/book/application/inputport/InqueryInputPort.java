package com.msa.book.application.inputport;

import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.InqueryUsecase;
import com.msa.book.framework.web.dto.RentItemOutputDTO;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.ReturnItemOutputDTO;
import com.msa.book.framework.web.dto.UserInputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class InqueryInputPort implements InqueryUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;

    @Override
    public Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.getUserId())
                .map(RentalCardOutputDTO::mapToDTO);
    }

    @Override
    public Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                .map(loadCard -> loadCard.getRentalItemList().stream().map(RentItemOutputDTO::mapToDTO).toList());
    }

    @Override
    public Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO) {
        return rentalCardOutputPort.loadRentalCard(userInputDTO.userId)
                .map(loadCard -> loadCard.getReturnItemList().stream().map(ReturnItemOutputDTO::mapToDTO).toList());
    }
}
