package ru.sbrf.school.java;

import java.util.Scanner;

public class Frame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var height = sc.nextLong();
        var width = sc.nextLong();
        sc.nextLine();
        var string = sc.nextLine();
        var strLength = string.length();

        if ((height < 3  || width < strLength + 2) && strLength > 0) {
            System.out.println("Ошибка");
        } else {
            var lineNumber = height % 2 == 0 ? height / 2 - 1 : height / 2;
            var lineEmptySpace = width - 2 - strLength;
            for (long i = 0; i < height; i++) {
                if (i == 0 || i == height - 1) {
                    for (long j = 0; j < width; j++) {
                        System.out.print("*");
                    }
                } else {
                    System.out.print("*");
                    if (i == lineNumber) {
                        for (long j = 0; j < lineEmptySpace / 2; j++) {
                            System.out.print(" ");
                        }
                        System.out.print(string);
                        for (long j = 0; j < (lineEmptySpace % 2 == 0 ? lineEmptySpace / 2 : lineEmptySpace / 2 + 1); j++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (long j = 0; j < width - 2; j++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
