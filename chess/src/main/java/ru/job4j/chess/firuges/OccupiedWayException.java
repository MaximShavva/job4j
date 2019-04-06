package ru.job4j.chess.firuges;

/**
 * Исключение. Используется, когда путь движения фигуры занят.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 08.04.2019г.
 */
public class OccupiedWayException extends Exception {
    public OccupiedWayException() {
        super("Путь движения фигуры занят");
    }
}
