package ru.sbrf.school.java;

import java.util.*;

public class MyInteger2 implements Comparable<MyInteger2> {
    private int number;

    public MyInteger2(int number) {
        this.number = number;
    }


    @Override
    public int compareTo(MyInteger2 o) {
        int result = Integer.compare(this.getDifferentDigitsCount(), o.getDifferentDigitsCount());
        return result == 0 ? Integer.compare(this.number, o.getNumber()) : result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger2 that = (MyInteger2) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public int getDifferentDigitsCount() {
        int differentDigitsCount = 0;
        int number = this.number;
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
        return differentDigitsCount;
    }

    public static void main(String[] args) {
        int n1 = 12_341_234;
        int n2 = 1_111;
        int n3 = 11_112_222;
        int n4 = 1_234_567;
        int n5 = 1_234;

        MyInteger2[] arr = new MyInteger2[] {new MyInteger2(n1),
                new MyInteger2(n2),
                new MyInteger2(n3),
                new MyInteger2(n4),
                new MyInteger2(n5)
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
