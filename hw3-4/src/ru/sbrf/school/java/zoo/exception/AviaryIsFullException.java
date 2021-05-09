package ru.sbrf.school.java.zoo.exception;

import ru.sbrf.school.java.zoo.animal.Animal;

public class AviaryIsFullException extends Exception {
    public AviaryIsFullException(Animal animal) {
        super("This aviary is full. Can't add " + animal.getName() + ".");
    }
}
