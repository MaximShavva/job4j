package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.ArrayList;

/**
 * Класс обеспечивает работу меню приложения (трекера).
 * Внутренние классы AddItem, ShowItems, UpdateItem,
 * DeleteItem, FindItemById, FindItemsByName, ExitProgram
 * содержат конкретные реализации UserAction.execute()
 * по работе с данными.
 *
 * @author Шавва Максим.
 * @version 1
 * @since 30.03.2019г.
 */
public class MenuTracker {
    /**
     * Строковые константы используются для отображения в пользовательском интерфейсе.
     */
    private static final String INPUTID = "Введите ID заявки: ";
    private static final String INPUTNAME = "Введите имя заявки (оставить пустым, если не меняется): ";
    private static final String DESK = "Введите описание заявки (оставить пустым, если не меняется): ";
    private static final String BLANK = "(оставить пустым, если не меняется)";
    private static final String NOID = "-------- Заявки с таким ID не существует ----------";
    private static final String NONAME = "-------- Заявки с таким именем не существует ----------";
    private static final String ADDITION = "------------ Добавление новой заявки --------------";
    private static final String BIDS = "------------ Все заявки на данный момент --------------";
    private static final String END = "------------ Конец списка заявок --------------";
    private static final String EDITION = "------------ Редактирование заявки: --------------";
    private static final String DELETION = "------------ Удаление заявки: --------------";
    private static final String DELETED = "------------ Заявка успешно удалена --------------";
    private static final String FINDID = "------------ Поиск заявки по ID: --------------";
    private static final String FINDNAME = "------------ Поиск заявки по имени: --------------";
    private static final String DETAILS = "Заявка:         Описание:                ID:";
    private static final String NEW = "------------ Новая заявка с ID: %s -----------%n";
    private static final String TABS = "%-15s %-24s %-16s%n";
    private static final String DATA = "----- Новые данные по заявке с Id: %s добавлены -----%n";

    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";

    /**
     * Константа меню для показа списка заявок.
     */
    private static final String ALL = "1";

    /**
     * Константа меню для редактирования заявки.
     */
    private static final String EDIT = "2";

    /**
     * Константа меню для удаления заявки.
     */
    private static final String DEL = "3";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String ID = "4";

    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final String NAME = "5";

    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";

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
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracking tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(Integer.parseInt(ADD), "Add new item."));
        this.actions.add(new ShowItems(Integer.parseInt(ALL), "Show all items."));
        this.actions.add(new UpdateItem(Integer.parseInt(EDIT), "Edit item."));
        this.actions.add(new DeleteItem(Integer.parseInt(DEL), "Delete item."));
        this.actions.add(new FindItemById(Integer.parseInt(ID), "Find item by Id."));
        this.actions.add(new FindItemsByName(Integer.parseInt(NAME), "Find items by name."));
        this.actions.add(new ExitProgram(ui, Integer.parseInt(EXIT), "Exit Program."));
    }

    /**
     * @param action добавляем в список.
     */
    public void addAction(UserAction action) {
        actions.add(action);
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

    private class AddItem extends BaseAction {

        protected AddItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод реализует добавление новый заявки в хранилище.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(ADDITION);
            String name = input.ask(INPUTNAME.replace(BLANK, ""));
            String desc = input.ask(DESK.replace(BLANK, ""));
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.printf(NEW, item.getId());
        }
    }

    private class ShowItems extends BaseAction {

        protected ShowItems(int key, String name) {
            super(key, name);
        }

        /**
         * Метод показывает все заявки на данный момент.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(BIDS);
            System.out.println(DETAILS);
            for (Item item : tracker.findAll()) {
                System.out.printf(TABS, item.getName(), item.getDecs(), item.getId());
            }
            System.out.println(END);
        }
    }

    private class UpdateItem extends BaseAction {

        protected UpdateItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод редактирует заявку.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(EDITION);
            String id = input.ask(INPUTID);
            Item old = tracker.findById(id);
            if (old == null) {
                System.out.println(NOID);
                return;
            }
            String name = input.ask(INPUTNAME);
            String desc = input.ask(DESK);
            if ("".equals(name)) {
                name = old.getName();
            }
            if ("".equals(desc)) {
                desc = old.getDecs();
            }
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.printf(DATA, id);
            }
        }
    }

    private class DeleteItem extends BaseAction {

        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        /**
         * Метод удаляет заявку с указанным ID.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(DELETION);
            String id = input.ask(INPUTID);
            if (tracker.delete(id)) {
                System.out.println(DELETED);
            } else {
                System.out.println(NOID);
            }
        }
    }

    private class FindItemById extends BaseAction {

        protected FindItemById(int key, String name) {
            super(key, name);
        }

        /**
         * Метод находит заявку с указанным ID.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(FINDID);
            String id = input.ask(INPUTID);
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(DETAILS);
                System.out.printf(TABS, item.getName(), item.getDecs(), item.getId());
            } else {
                System.out.println(NOID);
            }
        }
    }

    private class FindItemsByName extends BaseAction {

        protected FindItemsByName(int key, String name) {
            super(key, name);
        }

        /**
         * Метод находит все заявки с указанным именем.
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            System.out.println(FINDNAME);
            String name = input.ask(INPUTNAME.replace(BLANK, ""));
            Item[] items = tracker.findByName(name);
            if (items.length == 0) {
                System.out.println(NONAME);
            } else {
                System.out.println(DETAILS);
                for (Item item : items) {
                    System.out.printf(TABS, item.getName(), item.getDecs(), item.getId());
                }
            }
        }
    }

    private class ExitProgram extends BaseAction {
        private final StartUI ui;

        protected ExitProgram(StartUI ui, int key, String name) {
            super(key, name);
            this.ui = ui;
        }

        /**
         * Дла выхода из программы вызываем StartUI.stop().
         */
        @Override
        public void execute(Input input, Tracking tracker) {
            ui.stop();
            System.out.println("Пока!");
        }
    }
}
