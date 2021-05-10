package ru.sbrf.school.java.homework.zoo.exception;

import ru.sbrf.school.java.homework.zoo.aviary.Aviary;

public class TooMuchAviariesException extends Exception {
    public TooMuchAviariesException(Aviary aviary) {
        super("Can't add aviary number " + aviary.getNumber() + ". Aviaries' collection is already full.");
    }
}
