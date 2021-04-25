package ru.sbrf.school.java.zoo.animal;

public class Elephant extends Animal implements Walkable, Swimmable {
    @Override
    public void makeSound() {
        System.out.println("Pawoo!");
    }

    @Override
    public void askToEat() {
        System.out.println("I want leaves");
    }
}
