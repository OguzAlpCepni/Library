package com.library.libraryservice.client;

import com.library.libraryservice.dto.BookDto;
import com.library.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "BookService" ,path= "/v1/book" )
public interface BookServiceClient {
    @RequestMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable  String isbn);

    @GetMapping("/book/{bookId}")
    public ResponseEntity<BookDto> getBookById(@PathVariable  String bookId);

}
