package ru.sbrf.school.java.homework;

import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) {
        var map = new HashMap<String, Long>();

        map.put("Саша", 65L);
        map.put("Маша", 45L);
        map.put("Даша", 50L);
        map.put("Толя", 100L);

        System.out.println(getAvgWeight(map));
    }

    private static long getAvgWeight(HashMap<String, Long> map) {
        return map.values().stream().reduce(0L, Long::sum) / map.size();
    }
}
