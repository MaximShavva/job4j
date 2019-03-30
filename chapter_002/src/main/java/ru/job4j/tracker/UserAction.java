package ru.job4j.tracker;

/**
 * Интерфейс определяет методы по работе с пользователем и
 * с данными, общие для всех событий.
 *
 * @author Шавва Максим.
 * @version 1
 * @since 30.03.2019г.
 */
public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     *
     * @return ключ
     */
    int key();

    /**
     * Основной метод.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker);

    /**
     * Метод возвращает информацию о данном пункте меню.
     *
     * @return Строка меню
     */
    String info();
}