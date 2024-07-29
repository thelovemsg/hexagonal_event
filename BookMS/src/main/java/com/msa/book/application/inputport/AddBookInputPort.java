package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.AddBookUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.domain.model.vo.Classification;
import com.msa.book.domain.model.vo.Location;
import com.msa.book.domain.model.vo.Source;
import com.msa.book.framework.web.dto.BookInfoDTO;
import com.msa.book.framework.web.dto.BookOutputDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AddBookInputPort implements AddBookUsecase {

    private final BookOutputPort bookOutputPort;

    @Override
    public BookOutputDTO addBook(BookInfoDTO bookInfoDTO) {
        Book book = Book.enterBook(
                bookInfoDTO.getTitle()
                , bookInfoDTO.getAuthor()
                , bookInfoDTO.getIsbn()
                , bookInfoDTO.getDescription()
                , bookInfoDTO.getPublicDate()
                , Source.valueOf(bookInfoDTO.getSource())
                , Classification.valueOf(bookInfoDTO.getClassification())
                , Location.valueOf(bookInfoDTO.getLocation()));

        Book save = bookOutputPort.save(book);
        return BookOutputDTO.mapToDTO(save);
    }
}
