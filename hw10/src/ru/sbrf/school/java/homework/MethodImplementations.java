package ru.sbrf.school.java.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class MethodImplementations {
    static <T, R> List<R> map(List<T> origin, Function<T, R> mapper) {
        if (origin == null) {
            return null;
        }
        List<R> result = new ArrayList<>();

        for (T elem : origin) {
            result.add(mapper.apply(elem));
        }

        return result;
    }

    static <T> void forEach(List<T> origin, Consumer<T> consumer) {
        if (origin == null) {
            return;
        }
        for (T elem : origin) {
            consumer.accept(elem);
        }
    }

    static <T> List<T> filter(List<T> origin, Predicate<T> predicate) {
        if (origin == null) {
            return null;
        }
        List<T> result = new ArrayList<>();

        for (T elem : origin) {
            if (predicate.test(elem)) {
                result.add(elem);
            }
        }

        return result;
    }
    static <T> int count(List<T> origin, Predicate<T> predicate) {
        if (origin == null) {
            return 0;
        }
        int result = 0;

        for (T elem : origin) {
            if (predicate.test(elem)) {
                result++;
            }
        }

        return result;
    }



    static <T> T foldL(List<T> origin, BinaryOperator<T> binaryOperator) {
        if (origin == null || origin.size() == 0) {
            return null;
        }
        T result = origin.get(0);
        for (int i = 1; i < origin.size(); i++) {
            result = binaryOperator.apply(result, origin.get(i));
        }

        return result;
    }
    static <T> T foldR(List<T> origin, BinaryOperator<T> binaryOperator) {
        if (origin == null || origin.size() == 0) {
            return null;
        }
        int size = origin.size();

        T result = origin.get(size - 1);
        for (int i = size - 2; i >= 0; i--) {
            result = binaryOperator.apply(result, origin.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        List<String> list1 = map(list, x -> "String number " + x);
        forEach(list1, System.out::println);
        List<Integer> list2 = filter(list, x -> x % 2 == 0);
        forEach(list2, x -> {
            System.out.print(x + " ");
        });
        System.out.println();
        System.out.println("Чисел, кратных трем: " + count(list, x -> x % 3 == 0));
        System.out.println(foldL(list, (x, y) -> x * 2 + y));
        System.out.println(foldR(list, (x, y) -> x * 2 + y));
    }
}
