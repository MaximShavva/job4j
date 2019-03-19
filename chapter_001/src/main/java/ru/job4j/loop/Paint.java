package ru.job4j.loop;

/**
 * Класс создаёт различные фигуры из псевдографики.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 19.03.2019
 */
public class Paint {

    /**
     * Метод "рисует" правый треугольник псевдографикой.
     *
     * @param height высота треугольника.
     * @return треугольник.
     */
    public String rightTrl(int height) {
        // Буфер для результата.
        StringBuilder screen = new StringBuilder();
        // ширина будет равна высоте.
        int width = height;
        // внешний цикл двигается по строкам.
        for (int row = 0; row != height; row++) {
            // внутренний цикл определяет положение ячейки в строке.
            for (int column = 0; column != width; column++) {
                // если строка равна ячейке, то рисуем галку.
                // в данном случае строка определяет, сколько галок будет в строке
                if (row >= column) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод строки.
            screen.append(System.lineSeparator());
        }
        // Получаем результат.
        return screen.toString();
    }

    /**
     * Метод "рисует" левый треугольник псевдографикой.
     *
     * @param height высота треугольника.
     * @return треугольник.
     */
    public String leftTrl(int height) {
        StringBuilder screen = new StringBuilder();
        int width = height;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= width - column - 1) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }

    /**
     * Метод "рисует" пирамидку псевдографикой.
     *
     * @param height высота пирамидки.
     * @return пирамидка.
     */
    public String pyramid(int height) {
        StringBuilder screen = new StringBuilder();
        int minorHeight = height - 1;
        int width = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != width; column++) {
                if (row >= minorHeight - column && row >= column - minorHeight) {
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