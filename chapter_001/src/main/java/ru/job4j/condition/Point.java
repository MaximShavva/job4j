package ru.job4j.condition;

/**
 * Программа расчета асстояния между точками в системе координат.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 18.03.2019г.
 */
public class Point {

    /**
     * Идеальный вес для женщины.
     * @param x1 начало по х.
     * @param x2 конец по х.
     * @param y1 начало по у.
     * @param y2 конец по у.
     * @return расстояние между начальной и конечной точками.
     */
    public double distance(int x1, int y1, int x2, int y2) {
        double first = Math.pow(x2 - x1, 2);
        double second = Math.pow(y2 - y1, 2);
        return Math.sqrt(first + second);
    }
}
