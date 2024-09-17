package ru.sbrf.school.java;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CircBuf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        sc.nextLine();
        LinkedList<Long> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();


            if (str.startsWith("ENQ")) {
                long x = Long.parseLong(str.substring(4));
                queue.add(x);
            } else if (str.startsWith("DEQ")) {
                System.out.println(queue.pollFirst());
            } else {
                System.out.println(queue.isEmpty());
            }
        }
    }
}
