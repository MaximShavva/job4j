package ru.job4j.chess.firuges;

/**
 * Исключение. Используется, когда фигура не найдена в списке.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 08.04.2019г.
 */
public class FigureNotFoundException extends Exception {
    public FigureNotFoundException() {
        super("Фигура не найдена");
    }
}