package ru.sbrf.school.java.zoo.animal;

public class Cheetah extends Animal implements Walkable, FastRunnable {
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat gazelle");
    }
}
