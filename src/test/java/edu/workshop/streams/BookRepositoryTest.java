package edu.workshop.streams;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepositoryTest {
    private static final int EXPECTED_BOOK_COUNT = 10000;
    private static final int EXPECTED_AUTHORS_COUNT = 5841;
    private static final int EXPECTED_MULTI_AUTHOR_ENG_BOOKS = 1789;
    private static final int EXPECTED_NON_ENGLISH_BOOKS = 186;
    private static final int EXPECTED_LANGUAGE_COUNT = 25;
    private static BookRepository repository;

    @BeforeAll
    static void setup() {
        repository = new BookRepository(new File("books.csv"));
    }

    @Test
    void shouldCountBooks() throws IOException {
        try (BookIterator iterator = repository.iterator()) {
            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            assertThat(count).isEqualTo(EXPECTED_BOOK_COUNT);
        }
    }

    @Test
    void shouldCountDistinctAuthors() {
        Set<String> authors = repository.stream()
                .map(Book::getAuthors)
                .flatMap(this::getAuthorsAsStream)
                .collect(Collectors.toSet());
        assertThat(authors).hasSize(EXPECTED_AUTHORS_COUNT);
    }

    private Stream<String> getAuthorsAsStream(String authors) {
        return Stream.of(authors.split(",")).map(String::trim);
    }

    /* we consider null or empty language also as english */
    @Test
    void shouldCountBooksInEnglishWithMoreThanOneAuthor() {
        long count = repository.stream()
                .filter(book -> book.getLanguage().toLowerCase().startsWith("en"))
                .map(Book::getAuthors)
                .filter(authors -> getAuthorsAsStream(authors).count() > 1)
                .peek(System.out::println)
                .count();

        assertThat(count).isEqualTo(EXPECTED_MULTI_AUTHOR_ENG_BOOKS);
    }

    @Test
    void shouldFindNonEnglishBooks() {
        long count = repository.stream()
                .filter(book -> !book.getLanguage().startsWith("en") && book.getLanguage() != null && !"".equals(book.getLanguage()))
                .count();

        assertThat(count).isEqualTo(EXPECTED_NON_ENGLISH_BOOKS);
    }

    @Test
    void shouldFindDistinctLanguages() {
        Set<String> languages = repository.stream()
                .map(Book::getLanguage)
                .filter(language -> !"".equals(language))
                .collect(Collectors.toSet());
        System.out.println(languages);
        assertThat(languages).hasSize(EXPECTED_LANGUAGE_COUNT);
    }

    @Test
    void shouldCalculateAvgRatingPerLanguage() {
        Map<String, Double> languageRatings = repository.stream()
                .collect(Collectors.groupingBy(Book::getLanguage, Collectors.averagingDouble(Book::getAvgRating)));

        assertThat(languageRatings.get("pol")).isBetween(4.32, 4.33);
        assertThat(languageRatings.get("en-CA")).isBetween(3.93, 3.94);
    }

    @Test
    void shouldGetIsbnPerLanguage() {
        Map<String, Set<String>> isbnMap = repository.stream()
                .collect(Collectors.groupingBy(Book::getLanguage, Collectors.mapping(Book::getIsbn, Collectors.toSet())));

        assertThat(isbnMap.get("pol")).contains("8370540791", "8370541240", "8370540376", "8370540910", "8370541291");
    }


}