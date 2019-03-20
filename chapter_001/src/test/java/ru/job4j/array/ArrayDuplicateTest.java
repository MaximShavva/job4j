package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса ArrayDuplicate.
 *
 * @author Шавва Максим (masyam@mail.ru).
 * @version 1.
 * @since 20.03.2019.
 */
public class ArrayDuplicateTest {

    /**
     * Тест метода ArrayDuplicate.remove().
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        String[] input = {"Привет", "Труд", "Труд", "Мир", "Труд", "Пока", "Привет", "Супер", "Мир"};
        String[] expect = {"Привет", "Труд", "Супер", "Мир", "Пока"};
        ArrayDuplicate duplicate = new ArrayDuplicate();
        String[] result = duplicate.remove(input);
        assertThat(result, is(expect));
    }
}
