package ru.sbrf.school.java.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) {
        try {
            var file = new FileInputStream("hw12/src/ru/sbrf/school/java/homework/file.txt");
            try {
                file.skip(2);
            } catch (IOException e) {
                System.err.println("Не удалось пропустить 2 символа");
            }
            try {
                for (int i = 0; i < 4; i++) {
                    System.out.print((char) file.read());
                }
            } catch (IOException e) {
                System.err.println("Не удалось прочитать символ");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        }
    }
}
