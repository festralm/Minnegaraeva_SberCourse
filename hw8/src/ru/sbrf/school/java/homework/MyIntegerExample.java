package ru.sbrf.school.java.homework;

public class MyIntegerExample {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(123456);
        MyInteger myInteger1 = new MyInteger(12387405);

        for (int n : myInteger) {
            System.out.print(n + " ");
        }
        System.out.println();
        for (int n : myInteger1) {
            System.out.print(n + " ");
        }
    }
}
