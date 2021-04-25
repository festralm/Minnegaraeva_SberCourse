package ru.sbrf.school.java.zoo.animal;

public abstract class Animal {
    private String name;
    private String className;

    public Animal() {
        this.className = this.getClass().getSimpleName().toLowerCase();
    }

    public Animal(String name) {
        this.name = name;
    }

    public void sayHi() {
        System.out.println("Hi! I'm " + (this.name == null ? "" :  this.name + " ") + "the " + className + "!");
    }

    public void sayHi(String name) {
        System.out.println("Hi, " + name + "! I'm " + (this.name == null ? "" : this.name + " ") + "the " + className + "!");
    }

    public abstract void makeSound();
    public abstract void askToEat();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
