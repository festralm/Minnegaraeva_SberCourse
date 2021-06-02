package ru.sbrf.school.java;

import java.util.Scanner;

public class Kth {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long k = in.nextLong() + 1;
        // 1234567891011121314151617181920 ...
        // 1 - 9, 2 - 90, 3 - 900, 4 - 9_000, 5 - 90_000  ... - Разделили числа на группы
        // 9      180     2_700    36_000     450_000     ... - Посчитали количество цифр в группах
        long tens = 1; // Минимальное число в группе (10^groupNum)
        long groupNum = 1;
        long max = 9;
        long prevMax = 0; // Количество цифр до текущей группы
        while (k > max) {
            tens *= 10;
            groupNum++;
            prevMax = max;
            max += 9 * groupNum * tens;
        }

        k -= prevMax; // Номер цифры в текущей группе

        long div = (k - 1) / groupNum; // Номер числа в текущей группе
        long mod = k % groupNum; // Номер нужной цифры числа (0 - последняя)

        long res = tens + div;

        if (mod > 0) {
            for (long j = 0; j < groupNum - mod; j++) {
                res /= 10;
            }
        }

        res %= 10;

        System.out.println(res);
    }

}
