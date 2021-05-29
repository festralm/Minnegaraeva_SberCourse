package ru.sbrf.school.java.lesson;

import java.util.Optional;

public class Task1 {
    public static void main(String[] args) {
        divToNumbers(1, 2).ifPresent(System.out::println);
        divToNumbers(1, 0).ifPresent(System.out::println);
    }

    public static Optional<Double> divToNumbers(double num1, double num2) {
        if (num2 == 0) {
            return Optional.empty();
        } else {
            return Optional.of(num1 / num2);
        }
    }
}
