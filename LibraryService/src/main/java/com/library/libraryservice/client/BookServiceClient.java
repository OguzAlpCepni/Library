package com.library.libraryservice.client;

import com.library.libraryservice.dto.BookDto;
import com.library.libraryservice.dto.BookIdDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "BookService" ,path= "/v1/book" )
public interface BookServiceClient {

    Logger loggger = LoggerFactory.getLogger(BookServiceClient.class);

    @RequestMapping("/isbn/{isbn}")
    @CircuitBreaker(name = "getBookByIsbnCurcuitBreaker",fallbackMethod = "getBookFallBack")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable  String isbn);
    //feign clientta gönderdigin parametre + exception parametresi alır


    default ResponseEntity<BookIdDto> getBookFallBack(String isbn,Exception exception) {
        loggger.info("Book not found by isbn "+ isbn + "returning default BookDto origin");
        return ResponseEntity.ok(new BookIdDto("default-book","default-isbn"));
    }


    @GetMapping("/book/{bookId}")
    @CircuitBreaker(name = "getBookByIdCurcuitBreaker",fallbackMethod = "getBookByIdFallBack")
    public ResponseEntity<BookDto> getBookById(@PathVariable  String bookId);

    default ResponseEntity<BookDto> getBookByIdFallBack(String id,Exception exception) {
        loggger.info("Book not found by id "+ id + " returning default BookDto origin");
        return ResponseEntity.ok(new BookDto(new BookIdDto("default-book","default-isbn")));
    }
}
