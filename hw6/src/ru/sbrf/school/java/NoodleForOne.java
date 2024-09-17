package ru.sbrf.school.java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NoodleForOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine().toLowerCase();

        Set<Character> letters = new HashSet<>();

        for (char ch : word.toCharArray()) {
            letters.add(ch);
        }

        String usersWord;
        int score = 0;
        Set<String> words = new LinkedHashSet<>();

        do {
            System.out.println("Введите слово");
            usersWord = sc.nextLine().toLowerCase();

            if (!usersWord.isEmpty() && !usersWord.isBlank()) {
                if (!validateWord(usersWord, letters)) {
                    System.err.println("Введенное слово неправильное!");
                    continue;
                }

                if (words.add(usersWord)) {
                    System.out.println("+1");
                    score++;
                } else {
                    System.err.println("Такое слово уже вводили!");
                }
            }
        } while (!usersWord.isEmpty() || !usersWord.isBlank());

        System.out.println("Набрано очков: " + score + ".");
        System.out.println("Введенные слова: " + String.join(", ", words));
    }

    public static boolean validateWord(String usersWord, Set<Character> letters) {

        for (char ch : usersWord.toCharArray()) {
            if (!letters.contains(ch)) {
                return false;
            }
        }
        return true;
    }
}
