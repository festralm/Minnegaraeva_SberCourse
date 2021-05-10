package ru.sbrf.school.java.lesson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LetterFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();

        HashMap<Character, Integer> lettersFrequency = new HashMap<>();
        for (char ch : word.toCharArray()) {
            lettersFrequency.put(ch, lettersFrequency.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : lettersFrequency.entrySet()) {
            System.out.println("Буква " + entry.getKey() + ": " + entry.getValue());
        }
    }
}
