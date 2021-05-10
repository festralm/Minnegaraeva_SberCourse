package ru.sbrf.school.java.lesson;

import java.io.File;

public class Task2 {
    public static void main(String[] args) {
        var file = new File("parent/file.txt");

        System.out.println("Absolute path: " + file.getAbsolutePath());
        var dirName = file.getParent();
        System.out.println("Parent: " + dirName);

        var dir = new File("hw12\\src\\ru\\sbrf\\school\\java\\lesson\\" + dirName);
        System.out.println("Files:");

        var listFiles = dir.listFiles();

        if (listFiles != null) {
            for (var f : listFiles) {
                System.out.println(f.getName());
            }
        }

    }
}
