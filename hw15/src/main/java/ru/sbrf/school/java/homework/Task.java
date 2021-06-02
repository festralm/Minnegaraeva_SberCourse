package ru.sbrf.school.java.homework;

public class Task {
    public static void main(String[] args) {

    }

    public static int get(String string) {
        if (string == null) {
            throw new IllegalArgumentException("The string is null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("The string is empty");
        }
        if (string.isBlank()) {
            throw new IllegalArgumentException("The string is blank");
        }

        string = string.trim();

        var chars = string.toCharArray();

        int res = 0;
        int currRes = 0;

        for (var ch : chars){
            if (ch == '1') {
                currRes++;
            } else {
                if (ch != '0') {
                    throw new IllegalArgumentException("The string has illegal symbols");
                }
                res = Math.max(currRes, res);
                currRes = 0;
            }
        }

        return Math.max(currRes, res);
    }
}
