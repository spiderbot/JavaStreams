package com.piyush.joshi.stream.joins;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream1 = Stream.of(1, 3, 5);
        Stream<Integer> stream2 = Stream.of(2, 4, 6);
        Stream<Integer> stream3 = Stream.of(18, 15, 36);
        Stream<Integer> stream4 = Stream.of(99);

        Stream<Integer> resultingStream = Stream.of(
                        stream1, stream2, stream3, stream4)
                .flatMap(i -> i);

    }
}
