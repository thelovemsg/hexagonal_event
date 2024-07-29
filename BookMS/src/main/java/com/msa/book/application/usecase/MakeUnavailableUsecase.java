package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.BookOutputDTO;

public interface MakeUnavailableUsecase {
    BookOutputDTO makeUnavailable(Long bookNo);
}
