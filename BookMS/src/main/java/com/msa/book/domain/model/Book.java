package com.msa.book.domain.model;

import com.msa.book.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;
    private String title;
    @Embedded
    private BookDesc bookDesc;
    private Classification classification;
    private BookStatus bookStatus;
    private Location location;

    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicDate,
                                 Source source,
                                 Classification classification,
                                 Location location) {
        BookDesc bookDesc = BookDesc.createBookDesc(author, isbn, description, publicDate, source);
        Book book = new Book();
        book.setTitle(title);
        book.setBookDesc(bookDesc);
        book.setClassification(classification);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }

    public static Book sample() {
        return enterBook("엔터프라이즈 아키텍처 패턴", "마틴파울러", "123456789","정말 좋은 책"
                        , LocalDate.now(), Source.SUPPLY, Classification.COMPUTER, Location.JEONGJA);
    }

    public Book makeAvailable() {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnavailable() {
        this.setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }

}
