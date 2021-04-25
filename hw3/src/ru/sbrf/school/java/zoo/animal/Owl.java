package ru.sbrf.school.java.zoo.animal;

public class Owl extends Animal implements Flyable, Walkable {

    @Override
    public void makeSound() {
        System.out.println("Hoot-hoot");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat mouse");
    }
}
