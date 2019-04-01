package ru.job4j.tracker;

/**
 * Класс расширяет RuntimeException.
 *
 * @author Шавва Максим.
 * @version 1
 * @since 01.04.2019г.
 */
public class MenuOutException extends RuntimeException {
    public MenuOutException(String msg) {
        super(msg);
    }
}
