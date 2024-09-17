package com.library.libraryservice.service.abstracts;

import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;

public interface LibraryService {


    public LibraryDto getAllBookLibraryById(String id);
    public LibraryDto createLibrary();
    public void addBookToLibrary(AddBookRequest addBookRequest);
}
