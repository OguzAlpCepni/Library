package com.book.bookservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @GenericGenerator(name="UUID",strategy = "org.hibernate.id.UUIDGenerator")
    private String bookId;

    private String title;
    private int bookYear;
    private String author;
    private String pressName;
    private String isbn;


}

