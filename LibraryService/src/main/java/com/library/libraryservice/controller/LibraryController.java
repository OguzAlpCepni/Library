package com.library.libraryservice.controller;

import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.repository.LibraryRepository;
import com.library.libraryservice.service.abstracts.LibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {

    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;
    private final Environment env;



    public LibraryController(LibraryService libraryService, Environment env) {
        this.libraryService = libraryService;
        this.env = env;

    }
    @Value("${library.service.count}")
    private Integer count;

    @GetMapping("{id}")
    public ResponseEntity<LibraryDto> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAllBookLibraryById(id));
    }
    @PostMapping
    public ResponseEntity<LibraryDto> createLibrary() {
        logger.info("Library created on port number " + env.getProperty("local.server.port"));
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest addBookRequest) {
        libraryService.addBookToLibrary(addBookRequest);
        return ResponseEntity.ok().build();
    }
    @GetMapping()
    public ResponseEntity<List<String>> getAllLibraries() {
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }
    @GetMapping("/count")
    public ResponseEntity<String> getCount(){
        return ResponseEntity.ok("Library Service count : "+ count);
    }
}

