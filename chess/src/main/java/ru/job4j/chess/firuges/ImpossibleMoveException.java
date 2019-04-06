package ru.job4j.chess.firuges;

/**
 * Исключение. Используется, когда пользователь пытается совершить недопустимый ход.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 08.04.2019г.
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
        super("Такой ход недопустим");
    }
}
