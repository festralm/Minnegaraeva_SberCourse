package ru.sbrf.school.java.zoo.animal;

import java.sql.Timestamp;

public class Elephant extends Animal implements Walkable, Swimmable {
    public Elephant() {
        super(new Timestamp(6 * 60 * 1000));
    }


    @Override
    public void makeSound() {
        System.out.println("Pawoo!");
    }

    @Override
    public void askToEat() {
        System.out.println("I want leaves");
    }


}
