package ru.job4j.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс содержит метод transform() для преобразования
 * матрицы в список.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 26.04.2019г.
 */
public class FlatMap {

    /**
     * @param matrix Матрица, преобразуемая в список.
     * @return список.
     */
    public List<Integer> transform(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}