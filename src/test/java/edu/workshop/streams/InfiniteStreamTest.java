package edu.workshop.streams;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class InfiniteStreamTest {

    @Test
    void shouldGeneratePositiveNegativeLongsInfinitely() {
        PrimitiveIterator.OfInt factors = IntStream.iterate(1, i -> i * -1).iterator();
        long[] result = LongStream.iterate(1, i -> i + 1)
                .map(i -> i * factors.nextInt())
                .limit(5)
                .toArray();
        assertThat(result).contains(1, -2, 3, -4, 5);
    }

    @Test
    void shouldMapStringToInteger() {
        int testValue = 104528;
        PrimitiveIterator.OfInt factors = IntStream.iterate(1, i -> i * 10).iterator();
        int res = new StringBuilder(Integer.toString(testValue)).reverse().toString().chars()
                .map(number -> number - '0')
                .map(number -> number * factors.nextInt())
                .sum();
        assertThat(res).isEqualTo(testValue);
    }

    @Test
    void shouldGenerateFibonacci() {
        long[] fibonacci = Stream
                .iterate(new FibonacciPoint(1, 0), point -> new FibonacciPoint(point.current + point.prev, point.current))
                .mapToLong(FibonacciPoint::getCurrent)
                .limit(10)
                .toArray();
        assertThat(fibonacci).contains(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }

    @AllArgsConstructor
    @Data
    private class FibonacciPoint {
        private long current;
        private long prev;
    }
}
