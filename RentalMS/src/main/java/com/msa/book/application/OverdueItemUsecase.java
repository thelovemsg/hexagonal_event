package com.msa.book.application;

import com.msa.book.framework.web.dto.RentalCardOutputDTO;
import com.msa.book.framework.web.dto.UserItemInputDTO;

public interface OverdueItemUsecase {
    RentalCardOutputDTO overdueItem(UserItemInputDTO rental) throws Exception;
}
