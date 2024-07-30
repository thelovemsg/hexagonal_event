package com.msa.book.application.inputport;

import com.msa.book.application.outputport.EventOutputPort;
import com.msa.book.application.outputport.RentalCardOutputPort;
import com.msa.book.application.ClearOverdueItemUsecase;
import com.msa.book.domain.model.RentalCard;
import com.msa.book.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.book.framework.web.dto.RentalResultOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ClearOverdueItemInputPort implements ClearOverdueItemUsecase {

    private final RentalCardOutputPort rentalCardOutputPort;
    private final EventOutputPort eventOutputPort;

    @Override
    public RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception {
        RentalCard rentalCard = rentalCardOutputPort.loadRentalCard(clearOverdueInfoDTO.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("해당 카드가 존재하지 않습니다."));

        rentalCard.makeRentalAvailable(clearOverdueInfoDTO.getPoint());

        eventOutputPort.occurOverdueClearedEvent(RentalCard.createOverdueClearedEvent(rentalCard.getMember(), clearOverdueInfoDTO.getPoint()));

        return RentalResultOutputDTO.mapToDTO(rentalCard);
    }
}
