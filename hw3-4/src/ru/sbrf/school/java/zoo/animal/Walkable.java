package ru.sbrf.school.java.zoo.animal;

public interface Walkable {
    default void walk() {
        System.out.println("I'm walking");
    }
}
