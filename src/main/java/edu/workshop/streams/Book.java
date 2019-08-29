package edu.workshop.streams;

import lombok.Data;

@Data
public class Book {
    private final String id;
    private final String isbn;
    private final String title;
    private final String authors;
    private final String language;
    private final double avgRating;
}