package ru.job4j.tracker;

import java.util.ArrayList;

/**
 * Класс должен обеспечить полноценную работу всего приложения (трекера).
 *
 * @author Шавва Максим.
 * @version 3
 * @since 01.04.2019г.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        ArrayList<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", convertIntegers(range)));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Конвертируем список в массив
     *
     * @param integers список <Integer>
     * @return массив int[]
     */
    public static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    /**
     * Запускт программы.
     * @param args параметры консоли.
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}