package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования ConvertMatrix2List.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 13.04.2019г.
 */
public class ConvertMatrix2ListTest {
    /**
     * Тестируем преобразование массива 2х2 методом toList().
     */
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {{1, 2},{3, 4}};
        List<Integer> expect = List.of(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }

    /**
     * Тестируем преобразование списка 2x массивов
     * в список из всех данных методом convert.
     */
    @Test
    public void when2ArraysThenList() {
        ConvertMatrix2List convertList = new ConvertMatrix2List();
        List<int[]> input = List.of(new int[]{1, 2}, new int[]{3, 4, 5});
        List<Integer> result = convertList.convert(input);
        List<Integer> expect = List.of(1, 2, 3, 4, 5);
        assertThat(result, is(expect));
    }
}