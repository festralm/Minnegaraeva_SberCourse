package ru.sbrf.school.java.homework.zoo;

import ru.sbrf.school.java.homework.zoo.animal.*;
import ru.sbrf.school.java.homework.zoo.aviary.Aviary;
import ru.sbrf.school.java.homework.zoo.aviary.AviaryCollection;
import ru.sbrf.school.java.homework.zoo.exception.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bear bear = new Bear();
        Cheetah cheetah = new Cheetah();
        Crocodile crocodile = new Crocodile();
        Elephant elephant = new Elephant();
        Owl owl = new Owl();
        Penguin penguin = new Penguin();
        Wolf wolf = new Wolf();

        Animal[] animals = new Animal[]{bear, cheetah, crocodile, elephant, owl, penguin, wolf};
        String[] names = new String[]{"Fluffy", "Sarah", "Nibbles", "Hubby", "Sovunya", "Pororo", "Buddy"};

        for (int i = 0; i < animals.length; i++) {
            test(animals[i], names[i]);
        }

        System.out.println("Проверка исключений: ");
        System.out.println("Для проверки исключений нужно примерно 10 секунд\n"+
                "(время жизни волка), чтобы продолжить, наберите '+'");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("+")) {
            testExceptions(wolf, owl);
        }
        System.out.println();

        System.out.println("Проверка вольера: ");
        Aviary aviary1 = new Aviary(2);
        Aviary aviary2 = new Aviary(3);
        try {
            aviary1.addAnimal(bear);
            aviary1.addAnimal(cheetah);
            aviary1.addAnimal(crocodile);
        } catch (AnimalAlreadyInAviaryException | AviaryIsFullException e) {
            System.out.println(e.getMessage());
        }

        aviary1.removeAnimal(cheetah);
        try {
            aviary1.addAnimal(crocodile);
        } catch (AnimalAlreadyInAviaryException | AviaryIsFullException e) {
            System.out.println(e.getMessage());
        }

        try {
            aviary2.addAnimal(elephant);
            aviary2.addAnimal(owl);
            aviary2.addAnimal(owl);
        } catch (AnimalAlreadyInAviaryException | AviaryIsFullException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();


        System.out.println("Проверка нескольких вольеров: ");
        AviaryCollection aviaryCollection = new AviaryCollection(2);
        try {
            aviaryCollection.addAviary(aviary1);
            aviaryCollection.addAviary(aviary2);
            aviaryCollection.addAviary(new Aviary(15));
        } catch (TooMuchAviariesException e) {
            System.out.println(e.getMessage());
        }

        try {
            aviaryCollection.addAnimal(penguin, 2);
            aviaryCollection.addAnimal(wolf, 3);
        } catch (AnimalAlreadyInAviaryException | AviaryDoesNotExistsException | AviaryIsFullException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void test(Animal animal, String name) {
        System.out.println("Тест класса " + animal.getClass().getSimpleName());
        System.out.println("----------");

        animal.setName(name);
        System.out.println("Имя животного: " + animal.getName());
        try {
            animal.sayHi();
        } catch (EmptyNameException | AnimalIsDeadException e) {
            System.out.println(e.getMessage());
        }
        try {
            animal.sayHi("Alia");
        } catch (EmptyNameException | AnimalIsDeadException e) {
            System.out.println(e.getMessage());
        }
        animal.makeSound();
        try {
            animal.eat();
        } catch (AnimalIsDeadException e) {
            e.printStackTrace();
        }
        System.out.println("----------");

        testInterfaces(animal);
    }

    public static void testInterfaces(Animal animal) {
        System.out.println("Отличающиеся методы: ");
        if (animal instanceof Walkable) {
            System.out.print("Может ходить: ");
            ((Walkable) animal).walk();
        }
        if (animal instanceof FastRunnable) {
            System.out.print("Может быстро бегать: ");
            ((FastRunnable) animal).run();
        }
        if (animal instanceof Climbable) {
            System.out.print("Может лазать: ");
            ((Climbable) animal).climb();
        }
        if (animal instanceof Flyable) {
            System.out.print("Может летать: ");
            ((Flyable) animal).fly();
        }
        if (animal instanceof Swimmable) {
            System.out.print("Может плавать: ");
            ((Swimmable) animal).swim();
        }
        System.out.println();
    }

    public static void testExceptions(Animal animal1, Animal animal2) throws InterruptedException {
        while (animal1.isAlive() || animal2.isAlive()) {
            testAnimalsExceptions(animal1);
            testAnimalsExceptions(animal2);
            Thread.sleep(500);
            System.out.println();
        }
        testAnimalsExceptions(animal1);
        testAnimalsExceptions(animal2);
    }

    public static  void testAnimalsExceptions(Animal animal) {
        if (animal.isAlive()) {
            System.out.println(animal.getName() + ": " + animal.getAge());
        }
        try {
            try {
                animal.sayHi(null);
            } catch (EmptyNameException ignored) {
                try {
                    animal.sayHi();
                } catch (EmptyNameException ignored1) {

                }
            }
        } catch (AnimalIsDeadException e) {
            System.out.println(animal.getName() + " passed away");
        }
    }
}
