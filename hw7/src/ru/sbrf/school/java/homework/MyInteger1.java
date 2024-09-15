package ru.sbrf.school.java.homework;

import java.util.Arrays;
import java.util.Objects;

public class MyInteger1 implements Comparable<MyInteger1> {
    private int number;

    public MyInteger1(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(MyInteger1 o) {
        int result = Integer.compare(this.getPrimeNumbersCount(), o.getPrimeNumbersCount());
        return result == 0 ? Integer.compare(this.number, o.getNumber()) : result;
    }

    private int getPrimeNumbersCount() {
        int primeNumbersCount = 0;
        for (int i = 2; i <= this.number / 2; i++) {
            if (this.number % i == 0 && isPrime(i)) {
                primeNumbersCount++;
            }
        }
        return primeNumbersCount;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyInteger1 that = (MyInteger1) o;
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

    public static void main(String[] args) {
        int n1 = 5 * 5 * 7 * 7 * 11 * 11;
        int n2 = 2 * 3;
        int n3 = 2 * 3 * 5;
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
    }
}
