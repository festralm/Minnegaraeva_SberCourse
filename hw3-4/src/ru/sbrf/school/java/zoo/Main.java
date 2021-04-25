package ru.sbrf.school.java.zoo;

import ru.sbrf.school.java.zoo.animal.*;
import ru.sbrf.school.java.zoo.exception.AnimalIsDeadException;
import ru.sbrf.school.java.zoo.exception.EmptyNameException;

import java.sql.Timestamp;
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
        System.out.println("Для проверки исключений нужно примерно 5 секунд\n"+
                "(время жизни волка), чтобы продолжить, наберите '+'");
        Scanner sc = new Scanner(System.in);
        String confirm = sc.nextLine();
        if (confirm.equals("+")) {
            testExceptions(wolf, owl);
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
