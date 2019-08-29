package edu.workshop.streams;

import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.*;

public class SneakyThrowsTest {

    @Test
    void shouldCompile() throws NumberFormatException {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy( () -> {
            Optional.of("test")
                    .map(unchecked(this::getAnInt))
                    .get();
        });
    }

    private int getAnInt(String string) throws NumberFormatException {
        return Integer.parseInt(string);
    }

    static <T, R> Function<T, R> unchecked(ThrowingFunction<T, R> f) {
        return t -> {
            try {
                return f.apply(t);
            } catch (Exception ex) {
                return ThrowingFunction.sneakyThrow(ex);
            }
        };
    }

    public interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;

        @SuppressWarnings("unchecked")
        static <T extends Exception, R> R sneakyThrow(Exception t) throws T {
            throw (T) t;
        }
    }

}