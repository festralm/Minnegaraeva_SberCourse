package ru.sbrf.school.java.homework.zoo.animal;

public interface FastRunnable {
    default void run() {
        System.out.println("I'm running very fast");
    }
}
