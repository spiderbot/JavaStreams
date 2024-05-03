package com.piyush.joshi.predicate;

import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    // used to filter
    public static void main(String[] args) {

        // used to filter .
        Stream<String> stream = Stream.of("piyush","joshi","rohan","joshi","prisha","joshi");
        Predicate<String> predicate1 = name -> name.contains("j");
        Predicate<String> predicate2 = name -> name.contains("h");

        stream.filter(predicate1.and(predicate2)).forEach(element -> {
            System.out.println(element);
        });
    }
}
