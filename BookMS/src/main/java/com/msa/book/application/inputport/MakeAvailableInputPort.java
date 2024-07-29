package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.BookOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeAvailableInputPort implements MakeAvailableUsecase {

    private final BookOutputPort bookOutputPort;

    @Override
    public BookOutputDTO makeAvailable(Long bookNo) {
        Book loadBook = bookOutputPort.loadBook(bookNo);
        loadBook.makeAvailable();
        return BookOutputDTO.mapToDTO(loadBook);
    }
}
