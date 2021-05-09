package ru.sbrf.school.java;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class SwimmerExample {
    public static void main(String[] args) {
        Swimmer swimmer = new Swimmer("John", 25);
        swimmer.swim(System.out::println);

        Supplier<String> supplier = swimmer::getName;
        BiConsumer<String, Integer> biConsumer = ((n, a) -> {
            swimmer.setName(n);
            swimmer.setAge(a);
        });

        biConsumer.accept("Alia", 21);
        System.out.println(supplier.get());


    }
}
