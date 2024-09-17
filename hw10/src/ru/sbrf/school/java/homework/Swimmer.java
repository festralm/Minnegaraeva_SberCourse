package ru.sbrf.school.java.homework;

import java.util.function.Consumer;

public class Swimmer {
    private String name;
    private Integer age;

    public Swimmer(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void swim(Consumer<String> c) {
        c.accept(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
