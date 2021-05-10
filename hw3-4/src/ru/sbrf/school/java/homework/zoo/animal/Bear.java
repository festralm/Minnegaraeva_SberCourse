package ru.sbrf.school.java.homework.zoo.animal;

import java.sql.Timestamp;

public class Bear extends Animal implements Walkable, Climbable {

    public Bear() {
        super(new Timestamp(2 * 60 * 1000));
    }

    @Override
    public void makeSound() {
        System.out.println("Roarr!");
    }

    @Override
    public void askToEat() {
        System.out.println("I wanna eat fish");
    }
}
