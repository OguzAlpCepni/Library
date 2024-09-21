package com.library.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@Builder
public class BookDto {

    private String bookId;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;
    private String isbn;

   

    public BookDto(String bookId, String title, int bookYear, String pressName, String author, String isbn) {
        this.bookId = bookId;
        this.title = title;
        this.bookYear = bookYear;
        this.pressName = pressName;
        this.author = author;
        this.isbn = isbn;
    }

    public BookDto(BookIdDto bookIdDto) {
        this.bookId = bookIdDto.getBookId();
        this.isbn = bookIdDto.getIsbn();
    }
}
