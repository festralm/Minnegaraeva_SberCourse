package ru.sbrf.school.java.zoo.animal;

public class Penguin extends Animal implements Swimmable, Walkable {
    @Override
    public void makeSound() {
        System.out.println("Quack");
    }

    @Override
    public void askToEat() {
        System.out.println("I want to eat crabs");
    }
}
