package ru.sbrf.school.java.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2 {
    public static void main(String[] args) {
        var list1 = List.of("Саша", "Маша", "Даша", "Паша", "Миша", "Гриша");
        var list2 = List.of("Саша", "Петя", "Юля", "Оля", "Петя");
        var list3 = List.of("Паша", "Юля", "Гриша", "Поля", "Толя");

        System.out.println(getDistinctNamesList(list1, list2, list3));
    }

    public static List<String> getDistinctNamesList(List<String> list1, List<String> list2, List<String> list3) {
        return Stream.concat(
                Stream.concat(list1.stream(), list2.stream()), list3.stream())
                .distinct()
                .collect(Collectors.toList());

    }
}
