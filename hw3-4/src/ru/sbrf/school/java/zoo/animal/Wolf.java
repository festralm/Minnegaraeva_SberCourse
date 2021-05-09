package ru.sbrf.school.java.zoo.animal;

import java.sql.Timestamp;

public class Wolf extends Animal implements Walkable, Swimmable {
    public Wolf() {
        super(new Timestamp(10 * 1000));
    }

    @Override
    public void makeSound() {
        System.out.println("Owooooo");
    }

    @Override
    public void askToEat() {
        System.out.println("Give me this sheep.");
    }
}
