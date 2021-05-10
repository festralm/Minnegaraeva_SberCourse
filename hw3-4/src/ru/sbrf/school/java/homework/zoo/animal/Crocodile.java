package ru.sbrf.school.java.homework.zoo.animal;

import java.sql.Timestamp;

public class Crocodile extends Animal implements Swimmable, Walkable {
    public Crocodile() {
        super(new Timestamp(8 * 60 * 1000));
    }


    @Override
    public void makeSound() {
        System.out.println("Hisss");
    }

    @Override
    public void askToEat() {
        System.out.println("Give me zebra!");
    }

}
