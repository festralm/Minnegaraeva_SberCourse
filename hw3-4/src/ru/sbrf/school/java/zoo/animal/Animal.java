package ru.sbrf.school.java.zoo.animal;

import ru.sbrf.school.java.zoo.exception.AnimalIsDeadException;
import ru.sbrf.school.java.zoo.exception.EmptyNameException;

import java.sql.Timestamp;

public abstract class Animal {
    private String name;
    private String className;
    private Timestamp born = new Timestamp(System.currentTimeMillis());
    protected Timestamp lifetime;


    public Animal(Timestamp lifetime) {
        this.className = this.getClass().getSimpleName().toLowerCase();
        this.lifetime = lifetime;
    }

    public void eat() throws AnimalIsDeadException {
        if (!isAlive()) {
            throw new AnimalIsDeadException(this.getName() + " is passed away:)");
        }
        askToEat();
    }

    public void sayHi() throws EmptyNameException, AnimalIsDeadException {
        if (!isAlive()) {
            throw new AnimalIsDeadException(this.getName() + " is passed away:)");
        }
        if (this.name == null) {
            throw new EmptyNameException("Animal's name is null");
        }
        System.out.println("Hi! I'm " + this.name + " the " + className + "!");
    }

    public void sayHi(String name) throws EmptyNameException, AnimalIsDeadException {
        if (!isAlive()) {
            throw new AnimalIsDeadException(this.getName() + " is passed away:)");
        }
        if (this.name == null) {
            throw new EmptyNameException("Animal's name is null");
        }
        if (name == null) {
            throw new EmptyNameException("Person's name is null");
        }
        System.out.println("Hi, " + name + "! I'm " + this.name + " the " + className + "!");
    }

    public abstract void makeSound();

    public abstract void askToEat();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        long age = System.currentTimeMillis() - born.getTime();
        if (new Timestamp(age).after(lifetime)) {
            age = lifetime.getTime();
        }
        return formatTime(age) + "out of " + formatTime(lifetime.getTime());
    }

    private String formatTime(long time) {
        long minutes = time / 1000 / 60;
        long seconds = (time - minutes * 60 * 1000) / 1000;
        long milliseconds = time - minutes * 60 * 1000 - seconds * 1000;
        String result = "";
        if (minutes != 0) {
            result += minutes + "m ";
        }
        if (seconds != 0) {
            result += seconds + "s ";
        }
        if (milliseconds != 0) {
            result += milliseconds + "ms ";
        }
        if (result.equals("")) {
            result = "0s ";
        }
        return result;
    }

    public boolean isAlive() {
        return lifetime.after(new Timestamp(System.currentTimeMillis() - born.getTime()));
    }
}
