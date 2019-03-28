package ru.job4j.tracker;

/**
 * Интерфес Input содержит 1 метод ask и служит
 * для подключения модулей тестирования либо класса
 * для ввода данных к программе.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 28.03.2019г.
 */
public interface Input {
    String ask(String question);
}
