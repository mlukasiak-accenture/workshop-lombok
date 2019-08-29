package edu.workshop.streams;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfiniteStreamTest {

    @Test
    void shouldGeneratePositiveNegativeLongsInfinitely() {
        long[] result = {};

        assertThat(result).contains(1, -2, 3, -4, 5);
    }

    @Test
    void shouldMapStringToInteger() {
        int testValue = 104528;
        int res = 0;
        assertThat(res).isEqualTo(testValue);
    }

    @Test
    void shouldGenerateFibonacci() {
        long[] fibonacci = {};
        assertThat(fibonacci).contains(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }
}