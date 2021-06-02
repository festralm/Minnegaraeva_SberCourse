package ru.sbrf.school.java.homework;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Tree {
    public static void main(String[] args) {
        tree(System.getProperty("user.dir"));
    }
    public static void tree(String path) {
        var file = new File(path);
        printDir(file, 0);
    }

    public static void printDir(File file, int count) {
        if (file.canRead()) {
            var listFiles = getNotHiddenSubdirectoriesList(file);
            for (int j = 0; j < listFiles.size(); j++) {
                File file1 = listFiles.get(j);
                if (count > 0) {
                    System.out.print("│   ");
                }
                for (int i = 0; i < (count - 1) * 4; i++) {
                    System.out.print(" ");
                }
                if (j == listFiles.size() - 1) {
                    System.out.print("└───");
                } else {
                    System.out.print("├───");
                }
                System.out.println(file1.getName());
                printDir(file1, count + 1);
            }
        }
    }

    public static List<File> getNotHiddenSubdirectoriesList(File file) {
        var result = new ArrayList<File>();

        var listFiles = file.listFiles();
        if (listFiles != null) {
            for (var f : listFiles) {
                if (!f.isHidden() && f.listFiles() != null) {
                    result.add(f);
                }
            }
        }

        return result.stream()
                .sorted(Comparator.comparing(File::getName))
                .collect(Collectors.toList());
    }
}
