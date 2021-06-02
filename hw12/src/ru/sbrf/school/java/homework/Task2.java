package ru.sbrf.school.java.homework;

import java.io.*;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {
        var file = new File("hw12/src/ru/sbrf/school/java/homework/file2.txt");
        try {
            if (file.createNewFile()) {
                FileOutputStream fileStream = null;
                try {
                    fileStream = new FileOutputStream(file);
                } catch (FileNotFoundException e) {
                    System.err.println("не удалось открыть файл");
                }
                try {
                    if (fileStream != null) {
                        fileStream.write("Люблю Java!".getBytes());
                        fileStream.close();
                    }
                } catch (IOException e) {
                    System.err.println("Не удалось записать в файл");
                }
                System.out.println("Успешно записано");
            } else {
                System.out.println("Файл уже существует");
            }
        } catch (IOException e) {
            System.err.println("Не удалось создать файл");
        }
    }
}
