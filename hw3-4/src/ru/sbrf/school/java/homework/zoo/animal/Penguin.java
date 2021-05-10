package ru.sbrf.school.java.homework.zoo.animal;

import java.sql.Timestamp;

public class Penguin extends Animal implements Swimmable, Walkable {
    public Penguin() {
        super(new Timestamp(2 * 60 * 1000));
    }

    @Override
    public void makeSound() {
        System.out.println("Quack");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat crabs");
    }
}
