package ru.sbrf.school.java.homework.zoo.aviary;

import ru.sbrf.school.java.homework.zoo.animal.Animal;
import ru.sbrf.school.java.homework.zoo.exception.AnimalAlreadyInAviaryException;
import ru.sbrf.school.java.homework.zoo.exception.AviaryIsFullException;

import java.util.HashSet;

public class Aviary {
    private static int count = 0;
    private int number;
    private HashSet<Animal> animals = new HashSet<>();
    private int size;

    public Aviary(int size) {
        count++;
        this.number = count;
        this.size = size;
    }

    public boolean addAnimal(Animal animal) throws AnimalAlreadyInAviaryException, AviaryIsFullException {
        if (animals.size() >= size) {
            throw new AviaryIsFullException(animal);
        }
        if (animals.contains(animal)) {
            throw new AnimalAlreadyInAviaryException(animal);
        }
        return animals.add(animal);
    }

    public boolean removeAnimal(Animal animal) {
        return animals.remove(animal);
    }

    public int getNumber() {
        return number;
    }
}
