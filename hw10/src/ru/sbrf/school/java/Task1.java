package ru.sbrf.school.java;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Task1 {
    public static void main(String[] args) {
        System.out.println("Введите числа через пробел");
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println("-e - отфильтровать по четным элементам\n" +
                "-p - отфильтровать по положительным элементам");
        String predicate = sc.nextLine();


        switch (predicate) {
            case "-e":
                System.out.println(Arrays.toString(filter(array, a -> a % 2 == 0)));
                break;
            case "-p":
                System.out.println(Arrays.toString(filter(array, a -> a > 0)));
                break;
            default:
                System.out.println("Команда не распознана");

        }
    }

    private static int[] filter(int[] array, IntPredicate filterFunction) {
        return Arrays.stream(array).filter(filterFunction).toArray();

    }
}
