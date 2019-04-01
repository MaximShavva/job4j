package ru.job4j.tracker;

import java.util.*;

/**
 * Класс реализует метод ask() интерфейса Input,
 * возвращая данные, введённые пользователем с клавиатуры.
 *
 * @author Шавва Максим.
 * @version 2
 * @since 01.04.2019г.
 */
public class ConsoleInput implements Input {

    /**
     * Экземпляр класса scanner для считывания из потока in
     */
    private final Scanner scanner = new Scanner(System.in);

    /**
     * @param question Вопрос, который нужно вывести на консоль.
     * @return вернём строку, введённую с клавиатуры пользователем.
     */
    @Override
    public String ask(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    /**
     * @param question Диалоговый вопрос пользователю
     * @param range Массив номеров пунктов меню
     * @return выбранный пункт меню.
     */
    @Override
    public int ask(String question, int[] range) {
        int result = Integer.valueOf(ask(question));
        boolean missing = true;
        for (int i :range) {
            if (result == i) {
                missing = false;
                break;
            }
        }
        if (missing) {
            throw new MenuOutException("Ты ввел(а) неправильный пункт меню!");
        }
        return result;
    }
}