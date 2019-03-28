package ru.job4j.tracker;

import java.util.*;

/**
 * Класс реализует метод ask() интерфейса Input,
 * возвращая данные, введённые пользователем с клавиатуры.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 28.03.2019г.
 */
public class ConsoleInput implements Input {

    /**
     * Экземпляр класса scanner для считывания из потока in
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * @param question Вопрос, который нужно вывести на консоль.
     * @return вернём строку, введённую с клавиатуры пользователем.
     */
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}