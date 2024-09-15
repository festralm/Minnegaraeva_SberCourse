package ru.sbrf.school.java.lesson;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

public class Brackets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        LinkedList<Character> bracketsQueue = new LinkedList<>();

        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        brackets.put('>', '<');

        boolean isCorrect = true;
        for (char ch : str.toCharArray()) {
            if (brackets.containsValue(ch)) {
                bracketsQueue.add(ch);
            } else if (brackets.containsKey(ch)) {
                if (bracketsQueue.pollLast() != brackets.get(ch)) {
                    isCorrect = false;
                    break;
                }
            }
        }

        if (bracketsQueue.size() == 0 && isCorrect) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
