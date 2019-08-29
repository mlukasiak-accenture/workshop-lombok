package edu.workshop.streams;

import java.io.*;
import java.util.Iterator;

public class BookIterator implements Iterator<Book>, Closeable, AutoCloseable {
    private String line;
    private BufferedReader reader;

    BookIterator(File input) {
        try {
            this.reader = new BufferedReader(new FileReader(input));
            reader.readLine(); // skip header
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public boolean hasNext() {
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
        return line != null;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }

    @Override
    public Book next() {
        return parse(line.split(";"));
    }

    private Book parse(String[] line) {
        return new Book(line[0], line[1], line[2], line[3], line[4], Double.parseDouble(line[5]));
    }
}