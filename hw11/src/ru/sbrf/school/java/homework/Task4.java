package ru.sbrf.school.java.homework;

import java.util.List;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        var list1 = List.of(1L, 2L, 3L, 4L, 5L);
        var list2 = List.of(3L, 4L, 5L, 6L, 7L);

        System.out.println(getIntersection(list1, list2));
    }

    private static List<Long> getIntersection(List<Long> list1, List<Long> list2) {
        return list1.stream()
                .filter(list2::contains)
                .collect(Collectors.toList());
    }
}
