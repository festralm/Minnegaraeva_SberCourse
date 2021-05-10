package ru.sbrf.school.java.homework.zoo.animal;

public interface Climbable {
    default void climb() {
        System.out.println("Look, I'm climbing a tree!");
    }
}
