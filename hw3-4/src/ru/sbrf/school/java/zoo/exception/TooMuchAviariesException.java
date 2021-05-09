package ru.sbrf.school.java.zoo.exception;

import ru.sbrf.school.java.zoo.aviary.Aviary;

public class TooMuchAviariesException extends Exception {
    public TooMuchAviariesException(Aviary aviary) {
        super("Can't add aviary number " + aviary.getNumber() + ". Aviaries' collection is already full.");
    }
}
