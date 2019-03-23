package ru.job4j.loop;

/**
 * Класс для формирования рисунка шахматной доски в псевдографике.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class Board {

    /**
     * Метод возвращает наибольшее из 3 переданных ему чисел.
     *
     * @param width ширина доски.
     * @param height высота доски.
     * @return шахматная доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}