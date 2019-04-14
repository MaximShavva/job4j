package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.ArrayList;
import java.util.List;

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
    public MenuTracker(StartUI ui, Input input, Tracking tracker) {
        this.input = input;
        this.tracker = tracker;
        this.factory = new MenuFactory(ui);
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
        for (String item: menu) {
            switch (item) {
                case "add":
                    actions.add(factory.AddItemCreate(actions.size()));
                    break;
                case "show":
                    actions.add(factory.ShowItemsCreate(actions.size()));
                    break;
                case "update":
                    actions.add(factory.UpdateItemCreate(actions.size()));
                    break;
                case "delete":
                    actions.add(factory.DeleteItemCreate(actions.size()));
                    break;
                case "id":
                    actions.add(factory.FindItemByIdCreate(actions.size()));
                    break;
                case "name":
                    actions.add(factory.FindItemsByNameCreate(actions.size()));
                    break;
                case "exit":
                    actions.add(factory.ExitProgramCreate(actions.size()));
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
                System.out.printf("%s. %s%n", action.key(), action.info());
            }
        }
    }

    /**
     * @return Предоставляет длинну списка actions
     */
    public int getActionsLentgh() {
        return actions.size();
    }
}
