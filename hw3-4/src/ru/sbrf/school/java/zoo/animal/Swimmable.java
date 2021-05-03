package ru.sbrf.school.java.zoo.animal;

import java.util.ArrayList;
import java.util.List;

public interface Swimmable {
    default void swim() {
            System.out.println("I'm swimming");
    }

}
