package com.msa.bestbook.web;

import com.msa.bestbook.domain.BestBookService;
import com.msa.bestbook.domain.model.BestBook;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api")
@RequiredArgsConstructor
public class BestBookController {
    private final BestBookService bestBookService;

    @GetMapping("/books")
    public ResponseEntity<List<BestBook>> getAllBooks() {
        List<BestBook> books = bestBookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BestBook> getBookById(@PathVariable("id") String id) {
        Optional<BestBook> bookOptional = bestBookService.getBookById(id);
        return bookOptional.map(book -> new ResponseEntity<>(book,
                        HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/books")
    public ResponseEntity<BestBook> createBook(@RequestBody BestBook book) {
        BestBook createdBook = bestBookService.saveBook(book);
        return new ResponseEntity<>(createdBook, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BestBook> updateBook(@PathVariable("id") String id, @RequestBody BestBook book) {
        BestBook updatedBook = bestBookService.updateBook(id, book);
        return updatedBook != null
                ? new ResponseEntity<>(updatedBook, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
