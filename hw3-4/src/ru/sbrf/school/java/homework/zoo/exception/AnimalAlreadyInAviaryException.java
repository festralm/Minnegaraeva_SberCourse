package ru.sbrf.school.java.homework.zoo.exception;

import ru.sbrf.school.java.homework.zoo.animal.Animal;

public class AnimalAlreadyInAviaryException extends Exception{
    public AnimalAlreadyInAviaryException(Animal animal) {
        super("" + animal.getName() + " is already in this aviary.");
    }
}
