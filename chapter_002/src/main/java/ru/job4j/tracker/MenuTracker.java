package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс обеспечивает работу меню приложения (трекера).
 *
 * @author Шавва Максим.
 * @version 2.1
 * @since 13.04.2019г.
 */
public class MenuTracker {
    /**
     * Ссылка на фабрику Меню
     */
    CreateActions factory;

    /**
     * хранит ссылку на объект.
     */
    private Input input;

    /**
     * хранит ссылку на объект.
     */
    private Tracking tracker;

    /**
     * хранит ссылку на массив типа UserAction.
     */
    private ArrayList<UserAction> actions = new ArrayList<>();

    /**
     * Интерфейс используется для вывода на консоль либо
     * для записи в буфер с помощью лямбда-подстановки.
     */
    private final Consumer<String> output;

    /**
     * Хранит массив элементов меню, которые нам нужны.
     */
    private List<String> menu;

    /**
     * Конструктор.
     *
     * @param ui      ссылка на главный класс.
     * @param input   объект типа Input.
     * @param tracker объект типа Tracker.
     */
    public MenuTracker(StartUI ui, Input input, Tracking tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.factory = new MenuFactory(ui, output);
        this.output = output;
    }

    /**
     * Задаёт массив элементов меню, которые нам нужны.
     */
    public void setMenu(List<String> menu) {
        this.menu = menu;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        for (String item : menu) {
            switch (item) {
                case "add":
                    actions.add(factory.addItemCreate(actions.size()));
                    break;
                case "show":
                    actions.add(factory.showItemsCreate(actions.size()));
                    break;
                case "update":
                    actions.add(factory.updateItemCreate(actions.size()));
                    break;
                case "delete":
                    actions.add(factory.deleteItemCreate(actions.size()));
                    break;
                case "id":
                    actions.add(factory.findItemByIdCreate(actions.size()));
                    break;
                case "name":
                    actions.add(factory.findItemsByNameCreate(actions.size()));
                    break;
                case "exit":
                    actions.add(factory.exitProgramCreate(actions.size()));
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(String.format("%s. %s", action.key(), action.info()));
            }
        }
    }

    /**
     * @return Предоставляет длинну списка actions
     */
    public int getActionsLength() {
        return actions.size();
    }
}
