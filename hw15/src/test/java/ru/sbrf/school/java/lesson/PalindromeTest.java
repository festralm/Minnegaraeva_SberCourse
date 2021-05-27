package ru.sbrf.school.java.lesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PalindromeTest {
    @Test
    @DisplayName("проверка пустого слова на палиндром")
    public void testEmptyWord() throws Exception {
        var result = Palyndrom.isPalindrome("");

        assertFalse(result);
    }
    @Test
    @DisplayName("проверка слова с пробелами на палиндром")
    public void testBlankWord() throws Exception {
        var result = Palyndrom.isPalindrome("       ");

        assertFalse(result);
    }
}
