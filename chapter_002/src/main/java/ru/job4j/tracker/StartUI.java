package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;

import ru.job4j.tracker.singleton.*;

/**
 * Класс должен обеспечить полноценную работу всего приложения (трекера).
 *
 * @author Шавва Максим.
 * @version 3.1
 * @since 13.04.2019г.
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracking tracker;

    /**
     * Флажок разрешения работы главного цикла.
     */
    private boolean working = true;
    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracking tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * изменяем флаг working на false
     */
    public void stop() {
        this.working = false;
    }
    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this, this.input, this.tracker);
        menu.setMenu(Arrays.asList("add", "show", "update", "delete", "id", "name", "exit"));
        menu.fillActions();
        ArrayList<Integer> range = new ArrayList<>();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", convertIntegers(range)));
        } while (working && !"y".equals(this.input.ask("Exit?(y): ")));
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
        new StartUI(new ValidateInput(new ConsoleInput()), TrackerEagerEnum.INSTANCE).init();
    }
}