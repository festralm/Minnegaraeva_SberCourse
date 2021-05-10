package ru.sbrf.school.java.homework.zoo.animal;

public interface Swimmable {
    default void swim() {
            System.out.println("I'm swimming");
    }

}
