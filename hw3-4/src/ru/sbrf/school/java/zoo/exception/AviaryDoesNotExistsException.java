package ru.sbrf.school.java.zoo.exception;

public class AviaryDoesNotExistsException extends Exception {
    public AviaryDoesNotExistsException(int number) {
        super("Aviary " + number + " doesn't exists in this aviaries' collection.");
    }
}
