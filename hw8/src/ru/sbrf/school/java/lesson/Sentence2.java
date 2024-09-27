package ru.sbrf.school.java.lesson;

import java.util.Iterator;

public class Sentence2 implements Iterable<String>{

    private String sentence;

    public Sentence2(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    @Override
    public Iterator<String> iterator() {
        return new WordIterator(5);
    }

    public class WordIterator implements Iterator<String> {

        private int position;
        private int wordLength = 5;

        public WordIterator(int wordLength) {
            this.wordLength = wordLength;
        }

        @Override
        public boolean hasNext() {
            while (position < sentence.length()) {
                while (position < sentence.length() &&
                        Character.isWhitespace(sentence.charAt(position))) {
                    position++;
                }

                int newPosition = position;
                while (newPosition < sentence.length() &&
                        !Character.isWhitespace(sentence.charAt(newPosition))) {
                    newPosition++;
                }

                if (newPosition - position == wordLength) {
                    return true;
                } else {
                    position = newPosition;
                }
            }
            return false;

        }

        @Override
        public String next() {
            String word =  sentence.substring(position, position + 5);
            position += 5;
            return word;
        }
    }
}
