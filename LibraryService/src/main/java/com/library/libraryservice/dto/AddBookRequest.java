package com.library.libraryservice.dto;

import lombok.Data;

@Data
public class AddBookRequest {
    private String bookId;
    private String isbn;
}
