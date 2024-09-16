package com.book.bookservice.service.abstracts;

import com.book.bookservice.dto.BookDto;
import com.book.bookservice.dto.BookIdDto;

import java.util.List;

public interface BookService {


    public List<BookDto> getAllBooks();
    public BookIdDto findBookById(String isbn);
    public BookDto findBookDetaildById(String id);
}
