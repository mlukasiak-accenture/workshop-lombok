package edu.workshop.streams;

import java.io.*;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class BookRepository implements Iterable<Book> {

    private File input;

    public BookRepository(File file) {
        this.input = file;
    }

    public Stream<Book> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), Spliterator.IMMUTABLE | Spliterator.CONCURRENT), false);
    }

    @Override
    public BookIterator iterator() {
        return new BookIterator(input);
    }

}
