package ru.sbrf.school.java.homework.zoo.animal;

import java.sql.Timestamp;

public class Cheetah extends Animal implements Walkable, FastRunnable {
    public Cheetah() {
        super(new Timestamp(3 * 60 * 1000));
    }


    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat gazelle");
    }
}
