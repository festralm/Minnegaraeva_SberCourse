package ru.sbrf.school.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class MyInteger2 implements Comparator<MyInteger2>, Comparable<MyInteger2> {
    private int number;
    private int differentDigitsCount;

    public MyInteger2(int number) {
        this.number = number;
        Set<Integer> digits = new HashSet<>();

        while (number > 0) {
            int digit = number % 10;
            number /= 10;
            if (digits.contains(digit)) {
                continue;
            }
            digits.add(digit);
            differentDigitsCount++;
        }
    }

    @Override
    public int compare(MyInteger2 o1, MyInteger2 o2) {
        return Integer.compare(o1.getDifferentDigitsCount(), o2.getDifferentDigitsCount());
    }

    @Override
    public int compareTo(MyInteger2 o) {
        return compare(this, o);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public int getDifferentDigitsCount() {
        return differentDigitsCount;
    }

    public static void main(String[] args) {
        int n1 = 1_234;
        int n2 = 1_111;
        int n3 = 11_112_222;
        int n4 = 12_34_567;

        MyInteger2[] arr = new MyInteger2[] {new MyInteger2(n1),
                new MyInteger2(n2),
                new MyInteger2(n3),
                new MyInteger2(n4)
        };

        for (MyInteger2 n : arr) {
            System.out.println(n.getNumber() + ": " + n.getDifferentDigitsCount());
        }
        System.out.println();

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
