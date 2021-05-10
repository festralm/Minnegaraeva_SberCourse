package ru.sbrf.school.java.homework;

import java.util.Iterator;

public class Matrix implements Iterable<Integer>{
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MatrixIterator();
    }

    private class MatrixIterator implements Iterator<Integer> {
        private int i = 0;
        private int j = 0;

        @Override
        public boolean hasNext() {
            return matrix != null
                    && matrix.length != 0 &&
                    isProperIndex();
        }

        @Override
        public Integer next() {
            int res = matrix[i][j];

            moveIndexes();

            return res;
        }

        public MatrixIterator() {
            if (matrix != null && matrix.length != 0) {
                iDownUpperBound = i;
                iDownLowerBound = matrix.length - 2;
                jDownBound = 0;

                iRightBound = matrix.length - 1;
                jRightLeftBound = 0;
                jRightRightBound = matrix[i].length - 2;

                iUpUpperBound = i + 1;
                iUpLowerBound = matrix.length - 1;
                jUpBound = matrix[i].length - 1;

                iLeftBound = i;
                jLeftLeftBound = 2;
                jLeftRightBound = matrix[i].length - 1;
            }
        }

        //region
        private int count;

        private int iDownUpperBound; // 0, +1, +1 ...
        private int iDownLowerBound; // -1, -1 ...
        private int jDownBound;

        private int iRightBound;
        private int jRightLeftBound; // +1 ...
        private int jRightRightBound; // -1 ...

        private int iUpUpperBound; // +1 ...
        private int iUpLowerBound; // -1 ...
        private int jUpBound;

        private int iLeftBound;
        private int jLeftLeftBound; // +1 ...
        private int jLeftRightBound; // -1 ...
        //endregion

        private void moveIndexes() {
            if (count < matrix.length * matrix[i].length - 1) {
                if (i >= iDownUpperBound && i <= iDownLowerBound && j <= jDownBound) {
                    if (i == iDownLowerBound) {
                        iDownLowerBound--;
                        jDownBound++;
                        if (j != 0) {
                            iDownUpperBound++;
                        }
                    }
                    i++;
                } else if (i >= iRightBound && j >= jRightLeftBound && j <= jRightRightBound) {
                    if (j == jRightRightBound) {
                        iRightBound--;
                        jRightLeftBound++;
                        jRightRightBound--;
                    }
                    j++;
                } else if (i >= iUpUpperBound && i <= iUpLowerBound && j >= jUpBound) {
                    if (i == iUpUpperBound) {
                        iUpLowerBound--;
                        iUpUpperBound++;
                        jUpBound--;
                    }
                    i--;
                } else if (i <= iLeftBound && j >= jLeftLeftBound && j <= jLeftRightBound) {
                    if (j == jLeftLeftBound) {
                        iLeftBound++;
                        jLeftLeftBound++;
                        jLeftRightBound--;
                    }
                    j--;
                }
                count++;
            } else {
                i = -1;
                j = -1;
            }
        }

        private boolean isProperIndex() {
            return  j >= 0 && j < matrix[i].length;
        }
    }
}
