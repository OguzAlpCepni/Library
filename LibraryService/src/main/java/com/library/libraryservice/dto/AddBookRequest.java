package com.library.libraryservice.dto;

import lombok.Data;

@Data
public class AddBookRequest {
    private String bookId;  // you must change bookId this value must be libraryId su we send library id
    private String isbn;
}
