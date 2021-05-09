package ru.sbrf.school.java.zoo.animal;

public interface Climbable {
    default void climb() {
        System.out.println("Look, I'm climbing a tree!");
    }
}
