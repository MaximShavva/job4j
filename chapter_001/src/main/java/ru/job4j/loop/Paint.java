package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version 1
 * @since 0.1.
 */
public class Paint {

    /**
     * Метод "рисует" правый треугольник псевдографикой.
     *
     * @param height высота треугольника.
     * @return треугольник.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }

    /**
     * Метод "рисует" левый треугольник псевдографикой.
     *
     * @param height высота треугольника.
     * @return треугольник.
     */
    public String leftTrl(int height) {
        int minor = height - 1;
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= minor - column
        );
    }

    /**
     * Метод "рисует" пирамидку псевдографикой.
     *
     * @param height высота пирамидки.
     * @return пирамидка.
     */
    public String pyramid(int height) {
        int minor = height - 1;
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= minor - column && row >= column - minor
        );
    }

    /**
     * Общий метод рисования фигурок.
     *
     * @param height высота фигурки.
     * @param widht ширина фигурки.
     * @param predict условие для рисования "^" или " ".
     * @return фигурка.
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}