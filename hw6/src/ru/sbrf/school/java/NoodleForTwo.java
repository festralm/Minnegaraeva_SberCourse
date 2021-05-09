package ru.sbrf.school.java;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class NoodleForTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine().toLowerCase();

        Set<Character> letters = new HashSet<>();

        for (char ch : word.toCharArray()) {
            letters.add(ch);
        }

        String prevUsersWord;
        String usersWord = null;
        int score1 = 0;
        int score2 = 0;
        int wordsCount1 = 0;
        int wordsCount2 = 0;

        Set<String> words1 = new LinkedHashSet<>();
        Set<String> words2 = new LinkedHashSet<>();

        int i = 0;
        do {
            int playersNum = 2;
            if (i % 2 == 0) {
                playersNum = 1;
            }
            i++;
            System.out.println("Ходит игрок " + playersNum + ".");
            prevUsersWord = usersWord;
            usersWord = sc.nextLine().toLowerCase();

            if (!usersWord.isEmpty() && !usersWord.isBlank()) {
                if (!validateWord(usersWord, letters)) {
                    System.err.println("Введенное слово неправильное!");
                    continue;
                }
                if (playersNum == 1) {
                    if (addWord(words1, words2, usersWord)) {
                        score1 += usersWord.length();
                        wordsCount1++;
                    }
                } else {
                    if (addWord(words2, words1, usersWord)) {
                        score2 += usersWord.length();
                        wordsCount2++;
                    }
                }
            }
        } while (prevUsersWord == null ||
                (!usersWord.isEmpty() || !usersWord.isBlank())
                || (!prevUsersWord.isEmpty() || !prevUsersWord.isBlank()));

        System.out.println("Игрок 1:");
        System.out.println("Набрано очков: " + score1 + ".");
        System.out.println("Введено слов: " + wordsCount1 + ".");
        System.out.println("Введенные слова: " + String.join(", ", words1) + ".");
        System.out.println();

        System.out.println("Игрок 2:");
        System.out.println("Набрано очков: " + score2 + ".");
        System.out.println("Введено слов: " + wordsCount2 + ".");
        System.out.println("Введенные слова: " + String.join(", ", words2) + ".");
    }

    public static boolean validateWord(String usersWord, Set<Character> letters) {
        for (char ch : usersWord.toCharArray()) {
            if (!letters.contains(ch)) {
                return false;
            }
        }
        return true;
    }

    public static boolean addWord(Set<String> words1, Set<String> words2, String usersWord) {
        if (!words1.contains(usersWord) && !words2.contains(usersWord)) {
            words1.add(usersWord);
            System.out.println("+1");
            return true;
        }
        System.err.println("Такое слово уже вводили!");
        return false;
    }
}
