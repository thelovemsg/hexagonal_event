package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.InquiryUsecase;
import com.msa.book.framework.web.dto.BookOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class InquiryInputPort implements InquiryUsecase {

    private final BookOutputPort bookOutputPort;

    @Override
    public BookOutputDTO getBookInfo(long bookNo) {
        return BookOutputDTO.mapToDTO(bookOutputPort.loadBook(bookNo));
    }
}
