package com.piyush.joshi.stream.consumer;

import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {

        //used to print . consumer takes args but does not return anything
        Integer[] array = new Integer[]{1,2,3,4,5,6};
        Consumer<Integer> consumer1 = i -> System.out.println("number --> " + i);
        Consumer<Integer> consumer2 = i -> System.out.println("number square --> " + i*i);

        Arrays.stream(array).forEach(consumer1.andThen(consumer2));
    }
}
