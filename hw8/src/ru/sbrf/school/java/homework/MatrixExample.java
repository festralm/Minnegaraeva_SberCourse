package ru.sbrf.school.java.homework;

import java.util.List;

public class MatrixExample {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(new int[][] {
                new int[] {1, 8, 7},
                new int[] {2, 9, 6},
                new int[] {3, 4, 5}
        });

        Matrix matrix2 = new Matrix(new int[][] {
                new int[] {1, 20, 19, 18, 17, 16},
                new int[] {2, 21, 32, 31, 30, 15},
                new int[] {3, 22, 33, 36, 29, 14},
                new int[] {4, 23, 34, 35, 28, 13},
                new int[] {5, 24, 25, 26, 27, 12},
                new int[] {6, 7, 8, 9, 10, 11}
        });

        Matrix matrix3 = new Matrix(new int[][] {
            new int[] {1, 12, 11},
            new int[] {2, 13, 10},
            new int[] {3, 14, 9},
            new int[] {4, 15, 8},
            new int[] {5, 6, 7}
        });

        Matrix matrix4 = new Matrix(new int[][] {
                new int[] { 1, 2, 3, 4, 5}
        });

        Matrix matrix5 = new Matrix(new int[][] {
                new int[] { 1},
                new int[] { 2},
                new int[] { 3},
                new int[] { 4},
                new int[] { 5}
        });

        Matrix matrix6 = new Matrix(null);

        Matrix matrix7 = new Matrix(new int[][] {});


        List<Matrix> matrixList = List.of(matrix1, matrix2, matrix3, matrix4, matrix5, matrix6, matrix7);

        int i = 1;
        for (Matrix matrix : matrixList) {
            System.out.print(i + ": " + matrixInOneString(matrix));
            i++;
        }
    }

    private static String matrixInOneString(Matrix array) {
        StringBuilder res = new StringBuilder();
        for (int n : array) {
            res.append(n).append(" ");
        }
        res.append("\n");
        return res.toString();
    }
}
