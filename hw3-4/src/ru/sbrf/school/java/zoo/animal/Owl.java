package ru.sbrf.school.java.zoo.animal;

import java.sql.Timestamp;

public class Owl extends Animal implements Flyable, Walkable {

    public Owl() {
        super(new Timestamp(4 * 1000));
    }


    @Override
    public void makeSound() {
        System.out.println("Hoot-hoot");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat mouse");
    }
}
