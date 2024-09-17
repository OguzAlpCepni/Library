package com.book.bookservice.service.concreates;

import com.book.bookservice.dto.BookDto;
import com.book.bookservice.dto.BookIdDto;
import com.book.bookservice.exception.BookNotFoundException;
import com.book.bookservice.model.Book;
import com.book.bookservice.repository.BookRepository;
import com.book.bookservice.service.abstracts.BookService;
import com.book.bookservice.service.helper.BookHelper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManager implements BookService {

    private final BookRepository bookRepository;
    private final BookHelper bookHelper;

    public BookManager(final BookRepository bookRepository,final BookHelper bookHelper) {
        this.bookRepository = bookRepository;
        this.bookHelper = bookHelper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        //List<Book> books = bookRepository.findAll();
        /*for(Book book : books) {
            BookDto bookDto = BookDto.builder()
                    .bookId(book.getBookId())
                    .title(book.getTitle())
                    .bookYear(book.getBookYear())
                    .author(book.getAuthor())
                    .pressName(book.getPressName())
                    .isbn(book.getIsbn())
        }*/
        List<Book> books = bookRepository.findAll();
        return bookHelper.mapToBookDto(books);
    }

    @Override
    public BookIdDto findBookById(String isbn) {

        return bookRepository.findByIsbn(isbn).map(
                book -> BookIdDto.builder()
                        .bookId(book.getBookId())
                        .isbn(isbn).build()).orElseThrow(() -> new BookNotFoundException("book could not found by isbn: "+ isbn));

    }

    @Override
    public BookDto findBookDetaildById(String id) {

        return bookRepository.findById(id).map(book -> BookDto.builder()
                .bookId(book.getBookId())
                .title(book.getTitle())
                .bookYear(book.getBookYear())
                .author(book.getAuthor())
                .pressName(book.getPressName())
                .isbn(book.getIsbn()).build())
                .orElseThrow(() -> new BookNotFoundException("book could not found by id: "+ id));
    }
}
