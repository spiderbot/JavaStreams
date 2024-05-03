package com.piyush.joshi.function;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Function<Integer,String> function = (integer) -> {
            return String.valueOf(integer);
        };
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        IntStream.range(0,10).boxed().map(function).forEach(element -> {
            System.out.println("element -> " + element);
        });
        Arrays.stream(array).map(function).forEach(element -> {
            System.out.println("element -> " + element);
        });
    }
}
