package com.library.libraryservice.client;

import com.library.libraryservice.dto.BookDto;
import com.library.libraryservice.dto.BookIdDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BookService" ,path= "/v1/book" )
public interface BookServiceClient {
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable  String isbn);

    @GetMapping("/book/id")
    public ResponseEntity<BookDto> getBookById(@PathVariable  String id);

}
