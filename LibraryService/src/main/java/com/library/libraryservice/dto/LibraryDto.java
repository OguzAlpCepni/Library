package com.library.libraryservice.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
public class LibraryDto {

    private String libraryId;

    private List<BookDto> userBook;

    public LibraryDto(String libraryId) {
        this.libraryId = libraryId;
    }

    public LibraryDto(String libraryId, List<BookDto> userBook) {
        this.libraryId = libraryId;
        this.userBook = userBook;
    }
}
