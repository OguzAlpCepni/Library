package com.book.bookservice.service.helper;

import com.book.bookservice.dto.BookDto;
import com.book.bookservice.dto.BookIdDto;
import com.book.bookservice.exception.BookNotFoundException;
import com.book.bookservice.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookHelper {

    public List<BookDto> mapToBookDto(List<Book> books) {
        return books.stream().map(
                book ->BookDto.builder()
                        .bookId(book.getBookId())
                        .title(book.getTitle())
                        .bookYear(book.getBookYear())
                        .author(book.getAuthor())
                        .pressName(book.getPressName())
                        .isbn(book.getIsbn())
                        .build()).collect(Collectors.toList());
    }



}
