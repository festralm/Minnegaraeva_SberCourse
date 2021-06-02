package ru.sbrf.school.java.zoo.aviary;

import ru.sbrf.school.java.zoo.animal.Animal;
import ru.sbrf.school.java.zoo.exception.AnimalAlreadyInAviaryException;
import ru.sbrf.school.java.zoo.exception.AviaryDoesNotExistsException;
import ru.sbrf.school.java.zoo.exception.AviaryIsFullException;
import ru.sbrf.school.java.zoo.exception.TooMuchAviariesException;

import java.util.ArrayList;

public class AviaryCollection {
    private ArrayList<Aviary> aviaries = new ArrayList<>();
    private int size;

    public AviaryCollection(int size) {
        this.size = size;
    }

    public boolean addAviary(Aviary aviary) throws TooMuchAviariesException {
        if (aviaries.size() >= size) {
            throw new TooMuchAviariesException(aviary);
        }
        return aviaries.add(aviary);
    }

    public boolean removeAviary(Aviary aviary) {
        return aviaries.remove(aviary);
    }

    public boolean addAnimal(Animal animal, int number)
            throws AnimalAlreadyInAviaryException, AviaryIsFullException, AviaryDoesNotExistsException {
        if (!isAviaryByNumberExisting(number)) {
            throw new AviaryDoesNotExistsException(number);
        }
        return aviaries.get(number - 1).addAnimal(animal);
    }

    public boolean removeAnimal(Animal animal, int number) throws AviaryDoesNotExistsException {
        if (!isAviaryByNumberExisting(number)) {
            throw new AviaryDoesNotExistsException(number);
        }
        return aviaries.get(number - 1).removeAnimal(animal);
    }

    private boolean isAviaryByNumberExisting(int number) {
        for (Aviary aviary1 : aviaries) {
            if (aviary1.getNumber() == number) {
                return true;
            }
        }
        return false;
    }
}
