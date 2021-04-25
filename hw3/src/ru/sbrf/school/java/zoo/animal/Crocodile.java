package ru.sbrf.school.java.zoo.animal;

public class Crocodile extends Animal implements Swimmable, Walkable {
    @Override
    public void makeSound() {
        System.out.println("Hisss");
    }

    @Override
    public void askToEat() {
        System.out.println("Give me zebra!");
    }
}
