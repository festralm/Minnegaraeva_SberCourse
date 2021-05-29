package ru.sbrf.school.java.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.sbrf.school.java.homework.Task;

public class TaskTest {
    @Test
    public void test1() {
        var result = Task.get("1000011001110001010");

        Assertions.assertEquals(3, result);
    }
    @Test
    public void test2() {
        var result = Task.get("10001");

        Assertions.assertEquals(1, result);
    }
    @Test
    public void test3() {
        var result = Task.get("000");

        Assertions.assertEquals(0, result);
    }
    @Test
    public void test4() {
        var result = Task.get("0");

        Assertions.assertEquals(0, result);
    }
    @Test
    public void test5() {
        var result = Task.get("1");

        Assertions.assertEquals(1, result);
    }
    @Test
    public void test6() {
        var result = Task.get("1111");

        Assertions.assertEquals(4, result);
    }
    @Test
    public void testSpaces() {
        var result = Task.get("   1111   ");

        Assertions.assertEquals(4, result);
    }
    @Test
    public void testSpacesInMiddle() {
        var exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            Task.get("11    11");
                        }
                );

        var message = exception.getMessage();

        Assertions.assertEquals(
                "The string has illegal symbols",
                message
        );
    }

    @Test
    public void testIllegalSymbols() {
        var exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            Task.get("11gdtfh00123456781101");
                        }
                );

        var message = exception.getMessage();

        Assertions.assertEquals(
                "The string has illegal symbols",
                message
        );
    }
    @Test
    public void testNull() {
        var exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            Task.get(null);
                        }
                );

        var message = exception.getMessage();

        Assertions.assertEquals(
                "The string is null",
                message
        );
    }
    @Test
    public void testEmptyString() {
        var exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            Task.get("");
                        }
                );

        var message = exception.getMessage();

        Assertions.assertEquals(
                "The string is empty",
                message
        );
    }
    @Test
    public void testBlankString() {
        var exception = Assertions
                .assertThrows(
                        IllegalArgumentException.class,
                        () -> {
                            Task.get("    ");
                        }
                );

        var message = exception.getMessage();

        Assertions.assertEquals(
                "The string is blank",
                message
        );
    }
}
