package ru.job4j.flatmap;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования FlatMap.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 26.04.2019г.
 */
public class FlatMapTest {

    /**
     * Тестируем метод transform.
     */
    @Test
    public void whenMatrixThenList() {
        FlatMap flatMap = new FlatMap();
        Integer[][] matrix = {{1, 2}, {3, 4}};
        assertThat(flatMap.transform(matrix), is(List.of(1, 2, 3, 4)));
    }
}