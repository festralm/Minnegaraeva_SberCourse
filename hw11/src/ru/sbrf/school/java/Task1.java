package ru.sbrf.school.java;

import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {
    public static void main(String[] args) {
        var doubleOddPositiveSet = Stream.generate(() -> ThreadLocalRandom.current().nextInt())
                .filter(x -> x > 0 && x % 2 == 1)
                .map(x -> {
                    return 2L * x;
                })
                .peek(System.out::println)
                .limit(15)
                .collect(Collectors.toSet());
        System.out.print("sum: ");
        var sum = doubleOddPositiveSet.stream().reduce(0L, Long::sum);
        System.out.println(sum);

    }
}
