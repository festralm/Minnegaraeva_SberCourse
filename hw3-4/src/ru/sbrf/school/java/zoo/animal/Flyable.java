package ru.sbrf.school.java.zoo.animal;

public interface Flyable {
    default void fly() {
        System.out.println("I'm flying");
    }
}
