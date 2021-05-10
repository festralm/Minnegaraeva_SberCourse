package ru.sbrf.school.java;

import ru.sbrf.school.java.interfaces.QuadFunction;
import ru.sbrf.school.java.interfaces.TriFunction;

public class InterfacesExample {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> triFunction = (a, b, c) -> a + b + c;
        QuadFunction<Double, Double, Double, Double, Double> quadFunction = (a, b, c, d) -> a / b + c / d;

        System.out.println(triFunction.apply(1, 2, 3));
        System.out.println(quadFunction.apply(6.0, 5.0, 4.0, 3.0));
    }
}
