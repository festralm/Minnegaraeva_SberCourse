package ru.sbrf.school.java.zoo;

import ru.sbrf.school.java.zoo.animal.*;

public class Main {
    public static void main(String[] args) {
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
    }
    public static void test(Animal animal, String name) {
        System.out.println("Тест класса " + animal.getClass().getSimpleName());
        System.out.println();

        System.out.println("Возможность давать имя: ");
        System.out.println("Даем имя " + name + " животному (setName(String name))");
        animal.setName(name);
        System.out.println("Есть имя (getName()): " + animal.getName());
        System.out.println();

        System.out.print("Возможность разговора (метод sayHi()): ");
        animal.sayHi();
        System.out.println();

        System.out.print("Перегрузка метода (sayHi(String name)): ");
        animal.sayHi("Alia");
        System.out.println();

        System.out.print("Общий метод 1 (makeSound()): ");
        animal.makeSound();
        System.out.println();

        System.out.print("Общий метод 2 (askToEat()): ");
        animal.askToEat();
        System.out.println();

        System.out.println("Отличающиеся методы: ");
        if (animal instanceof Walkable) {
            System.out.print("Может ходить (walk()): ");
            ((Walkable) animal).walk();
        }
        if (animal instanceof FastRunnable) {
            System.out.print("Может быстро бегать (run()): ");
            ((FastRunnable) animal).run();
        }
        if (animal instanceof Climbable) {
            System.out.print("Может лазать (climb()): ");
            ((Climbable) animal).climb();
        }
        if (animal instanceof Flyable) {
            System.out.print("Может летать (fly()): ");
            ((Flyable) animal).fly();
        }
        if (animal instanceof Swimmable) {
            System.out.print("Может плавать (swim()): ");
            ((Swimmable) animal).swim();
        }
        System.out.println();
    }
}
