package ru.sbrf.school.java.zoo.animal;

public class Wolf extends Animal implements Walkable, Swimmable {
    @Override
    public void makeSound() {
        System.out.println("Owooooo");
    }

    @Override
    public void askToEat() {
        System.out.println("Give me this sheep.");
    }
}
