package com.msa.book.application;

import com.msa.book.framework.web.dto.ClearOverdueInfoDTO;
import com.msa.book.framework.web.dto.RentalResultOutputDTO;

public interface ClearOverdueItemUsecase {
    RentalResultOutputDTO clearOverdue(ClearOverdueInfoDTO clearOverdueInfoDTO) throws Exception;
}
