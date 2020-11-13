package com.practice.java8stream;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.stream.Stream;

public class StreamConstructor {
    public static <T> Stream<T> generateStreamFromCollection(Collection<T> collection) {
        return collection.stream();
    }

    public static Stream<String> generateStringStreamFromStringArray(String[] array) {
        // or Arrays.stream(array);
        return Stream.of(array);
    }

    public static Stream<String> generateStreamFromFile(Path path) throws IOException {
        return Files.lines(path, StandardCharsets.UTF_8);
    }

    public static Stream<Double> generateRandomDoubleStream() {
        return Stream.generate(Math::random);
    }

    public static Stream<Integer> generateArithmeticSequenceStream() {
        return Stream.iterate(0, n -> n + 1);
    }
}