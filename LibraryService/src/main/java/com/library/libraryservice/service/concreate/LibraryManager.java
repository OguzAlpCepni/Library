package com.library.libraryservice.service.concreate;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.BookDto;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.exception.LibraryNotFoundException;
import com.library.libraryservice.model.Library;
import com.library.libraryservice.repository.LibraryRepository;
import com.library.libraryservice.service.abstracts.LibraryService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryManager implements LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryManager(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    @Override
    public LibraryDto getAllBookLibraryById(String id) {
        Library library = libraryRepository.findById(id).orElseThrow(()->new LibraryNotFoundException("Library could not found"));

        LibraryDto libraryDto = new LibraryDto(library.getLibraryId(),library
                .getUserBook()
                .stream()
                .map(bookServiceClient::getBookById)
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList()));

        return libraryDto;
    }
    public LibraryDto createLibrary() {
        Library library = libraryRepository.save(new Library());
        return new LibraryDto(library.getLibraryId());
    }

    @Override
    public void addBookToLibrary(AddBookRequest addBookRequest) {
        String bookId = bookServiceClient.getBookByIsbn(addBookRequest.getIsbn()).getBody().getBookId();
        Library library = libraryRepository.findById(addBookRequest.getBookId()).orElseThrow(()->new LibraryNotFoundException("Library could not found"));
        library.getUserBook().add(bookId);
        libraryRepository.save(library);
    }

    @Override
    public List<String> getAllLibraries() {
        return libraryRepository.findAll().stream().map(Library::getLibraryId).collect(Collectors.toList());
    }


}
