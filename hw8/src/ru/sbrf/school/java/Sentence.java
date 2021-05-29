package ru.sbrf.school.java;

import java.util.Objects;

public class Sentence implements Comparable<Sentence> {

    private String sentence;


    public Sentence() {
    }

    public Sentence(String sentence) {
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }


    @Override
    public int compareTo(Sentence o) {
        int result = Integer.compare(this.getMaxLength(), o.getMaxLength());
        return result == 0 ? this.sentence.compareTo(o.sentence) : result;
    }

    private int getMaxLength() {
        String[] words = this.getSentence().split("\\s+");

        int maxLength = 0;
        for (String aWord : words) {
            if (aWord.length() > maxLength) {
                maxLength = aWord.length();
            }
        }

        return maxLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence1 = (Sentence) o;
        return Objects.equals(sentence, sentence1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
