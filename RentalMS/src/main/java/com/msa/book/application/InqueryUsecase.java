package com.msa.book.application;

import com.msa.book.framework.web.dto.RentItemOutputDTO;
import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.ReturnItemOutputDTO;
import com.msa.book.framework.web.dto.UserInputDTO;

import java.util.List;
import java.util.Optional;

public interface InqueryUsecase {
    Optional<RentalCardOutputDTO> getRentalCard(UserInputDTO userInputDTO);
    Optional<List<RentItemOutputDTO>> getAllRentItem(UserInputDTO userInputDTO);
    Optional<List<ReturnItemOutputDTO>> getAllReturnItem(UserInputDTO userInputDTO);

}
