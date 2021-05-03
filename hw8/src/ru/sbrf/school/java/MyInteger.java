package ru.sbrf.school.java;

import java.util.Iterator;

public class MyInteger implements Iterable<Integer> {
    private int number;

    public MyInteger(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyIntegerIterator();
    }

    class MyIntegerIterator implements Iterator<Integer> {

        private int pos;

        public MyIntegerIterator() {
            this.pos = number;
        }

        @Override
        public boolean hasNext() {
            return pos > 0;
        }

        @Override
        public Integer next() {
            int res = pos % 10;
            pos /= 10;
            return res;
        }
    }
}
