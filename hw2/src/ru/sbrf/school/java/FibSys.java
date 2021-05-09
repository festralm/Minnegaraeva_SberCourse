package ru.sbrf.school.java;

import java.util.ArrayList;
import java.util.Scanner;

public class FibSys {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var x = sc.nextLong();

        ArrayList<Long> fibs = new ArrayList<>();
        var result = new boolean[0];
        var n = 0;

        fibs.add(1L);
        fibs.add(1L);

        var first = true;
        while (x > 0) {
            if (first) {
                while (fibs.get(fibs.size() - 1) <= x) {
                    fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
                }
                n = fibs.size() - 2;
                result = new boolean[n];
                result[n - 1] = true;
                x -= fibs.get(fibs.size() - 2);
                first = false;
            } else {
                for (int i = 1; i < n; i++) {
                    if (fibs.get(i) > x) {
                        n = i;
                        break;
                    }
                }
                result[n - 2] = true;
                x -= fibs.get(n - 1);
            }
        }

        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i]) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }
        }
    }
}
