package ru.job4j.chess.firuges;

/**
 * Определяет некоторые методы для классов-фигур шахматной доски.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 08.04.2019г.
 */
public interface Figure {
    /**
     * Возвращает позицию фигуры на доске.
     */
    Cell position();

    /**
     * Проверяет, что фигура может так двигаться.
     *
     * @param source клетка исходного положения.
     * @param dest   клетка конечного положения.
     * @return массив клеток, через которые двигается фигурка.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * Возвращает название иконки исходя из названия класса.
     * Здесь используем заглушку default, чтобы не переопределять
     * метод во всех классах.
     */
    default String icon() {
        return String.format("%s.png", this.getClass().getSimpleName());
    }

    /**
     * Возвращает (создаёт) фигурку на новом месте.
     */
    Figure copy(Cell dest);
}