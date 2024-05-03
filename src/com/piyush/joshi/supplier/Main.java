package com.piyush.joshi.supplier;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Supplier<String[]> supplier = () -> {
            return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
        };
        for (String s : Arrays.asList(supplier.get())) {
            System.out.println("element -> " + s);
        }
    }
}
