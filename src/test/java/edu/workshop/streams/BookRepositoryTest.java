package edu.workshop.streams;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BookRepositoryTest {
    private static final int EXPECTED_BOOK_COUNT = 10000;
    private static final int EXPECTED_AUTHORS_COUNT = 5841;
    private static final int EXPECTED_MULTI_AUTHOR_ENG_BOOKS = 1789;
    private static final int EXPECTED_NON_ENGLISH_BOOKS = 186;
    private static final int EXPECTED_LANGUAGE_COUNT = 25;

    @Test
    void shouldCountBooks() throws IOException {
        int count = 0;
        assertThat(count).isEqualTo(EXPECTED_BOOK_COUNT);
    }

    @Test
    void shouldCountDistinctAuthors() {
        Set<String> authors = new HashSet<>();

        assertThat(authors).hasSize(EXPECTED_AUTHORS_COUNT);
    }

    /* we consider null or empty language also as english */
    @Test
    void shouldCountBooksInEnglishWithMoreThanOneAuthor() {
        long count = 0;

        assertThat(count).isEqualTo(EXPECTED_MULTI_AUTHOR_ENG_BOOKS);
    }

    @Test
    void shouldFindNonEnglishBooks() {
        long count = 0;

        assertThat(count).isEqualTo(EXPECTED_NON_ENGLISH_BOOKS);
    }

    @Test
    void shouldFindDistinctLanguages() {
        Set<String> languages = new HashSet<>();
        assertThat(languages).hasSize(EXPECTED_LANGUAGE_COUNT);
    }

    @Test
    void shouldCalculateAvgRatingPerLanguage() {
        Map<String, Double> languageRatings = new HashMap<>();

        assertThat(languageRatings.get("pol")).isBetween(4.32, 4.33);
        assertThat(languageRatings.get("en-CA")).isBetween(3.93, 3.94);
    }

    @Test
    void shouldGetIsbnPerLanguage() {
        Map<String, Set<String>> isbnMap = new HashMap<>();

        assertThat(isbnMap.get("pol")).contains("8370540791", "8370541240", "8370540376", "8370540910", "8370541291");
    }


}