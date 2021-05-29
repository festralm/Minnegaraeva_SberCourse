package ru.sbrf.school.java.lesson;

import java.util.LinkedList;
import java.util.Locale;

public class Palyndrom {
    public static boolean isPalindrome(String string) {
        if (string == null) {
            throw new IllegalArgumentException("Строка равняется null");
        }

        if (string.isEmpty() || string.isBlank()) {
            return false;
        }

        string = string
                .replaceAll("\\s+", "")
                .toLowerCase(Locale.ROOT);

        var chars = string.toCharArray();
        var length = chars.length;
        var stack = new LinkedList<Character>();
        for (int i = 0; i < length / 2; i++) {
            if (!Character.isAlphabetic(chars[i]) ||
                    !Character.isAlphabetic(chars[length - 1 - i]) ||
                    chars[i] != chars[length - 1 - i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("12")); // false
        System.out.println(isPalindrome("11")); // false
        try {
            System.out.println(isPalindrome(null)); // err
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
        System.out.println(isPalindrome("")); // false
        System.out.println(isPalindrome("   ")); // false
        System.out.println(isPalindrome("а")); // true
        System.out.println(isPalindrome("казак")); // true
        System.out.println(isPalindrome("А роза упала на лапу Азора")); // true
        System.out.println(isPalindrome("яЯ")); // true
        System.out.println(isPalindrome("ты")); // false
        System.out.println(isPalindrome("java")); // false
    }
}
