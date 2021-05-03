package ru.sbrf.school.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyInteger1 implements Comparator<MyInteger1>, Comparable<MyInteger1> {
    private int number;
    private int primeNumbersCount;

    public MyInteger1(int number) {
        this.number = number;
        for (int i = 2; i <= number / 2; i++) {
            if (number % i == 0 && isPrime(i)) {
                primeNumbersCount++;
            }
        }
    }

    private boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int compare(MyInteger1 o1, MyInteger1 o2) {
        return Integer.compare(o1.getPrimeNumbersCount(), o2.getPrimeNumbersCount());
    }
    @Override
    public int compareTo(MyInteger1 o) {
        return compare(this, o);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger1 that = (MyInteger1) o;
        return number == that.number && primeNumbersCount == that.primeNumbersCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, primeNumbersCount);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public int getPrimeNumbersCount() {
        return primeNumbersCount;
    }

    public static void main(String[] args) {
        int n1 = 2 * 3 * 5;
        int n2 = 2 * 3;
        int n3 = 5 * 5 * 7 * 7 * 11 * 11;
        int n4 = 7 * 13 * 2 * 43;

        MyInteger1[] arr = new MyInteger1[] {new MyInteger1(n1),
                new MyInteger1(n2),
                new MyInteger1(n3),
                new MyInteger1(n4)
        };

        for (MyInteger1 n : arr) {
            System.out.println(n.getNumber() + ": " + n.getPrimeNumbersCount());
        }
        System.out.println();

        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        MyInteger1 n6 = new MyInteger1(2 * 3);
        MyInteger1 n7 = new MyInteger1(n2);
    }
}
