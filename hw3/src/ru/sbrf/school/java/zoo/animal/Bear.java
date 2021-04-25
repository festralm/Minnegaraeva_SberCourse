package ru.sbrf.school.java.zoo.animal;

public class Bear extends Animal implements Walkable, Climbable {
    @Override
    public void makeSound() {
        System.out.println("Roarr!");
    }

    @Override
    public void askToEat() {
        System.out.println("I wanna eat fish");
    }
}
