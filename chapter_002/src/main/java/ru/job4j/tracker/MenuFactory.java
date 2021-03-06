package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.List;
import java.util.function.Consumer;

/**
 * Класс - фабрика объектов. Содержит методы по созданию UserAction-generic объектов.
 *
 * Внутренние классы AddItem, ShowItems, UpdateItem,
 * DeleteItem, FindItemById, FindItemsByName, ExitProgram
 * содержат конкретные реализации UserAction.execute()
 * по работе с данными.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 13.04.2019г.
 */
public class MenuFactory implements CreateActions {
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
    private static final String NEW = "------------ Новая заявка с ID: %s -----------";
    private static final String TABS = "%-15s %-24s %-16s";
    private static final String DATA = "----- Новые данные по заявке с Id: %s добавлены -----";

    /**
     * Ссылка на наш основной класс программы.
     */
    private StartUI ui;

    /**
     * Интерфейс используется для вывода на консоль либо
     * для записи в буфер с помощью лямбда-подстановки.
     */
    private final Consumer<String> output;

    public MenuFactory(StartUI ui, Consumer<String> output) {
        this.ui = ui;
        this.output = output;
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия add.
     */
    @Override
    public UserAction addItemCreate(int position) {
        return new AddItem(position, "Add new item.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия add.
     */
    @Override
    public UserAction showItemsCreate(int position) {
        return new ShowItems(position, "Show all items.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия update.
     */
    @Override
    public UserAction updateItemCreate(int position) {
        return new UpdateItem(position, "Edit item.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия delete.
     */
    @Override
    public UserAction deleteItemCreate(int position) {
        return new DeleteItem(position, "Delete item.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия Find Items By ID.
     */
    @Override
    public UserAction findItemByIdCreate(int position) {
        return new FindItemById(position, "Find item by Id.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия Find Items By Name.
     */
    @Override
    public UserAction findItemsByNameCreate(int position) {
        return new FindItemsByName(position, "Find items by name.");
    }

    /**
     * @param position позиция в меню.
     * @return реализайия действия Exit.
     */
    @Override
    public UserAction exitProgramCreate(int position) {
        return new ExitProgram(ui, position, "Exit Program.");
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
            output.accept(ADDITION);
            String name = input.ask(INPUTNAME.replace(BLANK, ""));
            String desc = input.ask(DESK.replace(BLANK, ""));
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept(String.format(NEW, item.getId()));
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
            output.accept(BIDS);
            output.accept(DETAILS);
            for (Item item : tracker.findAll()) {
                output.accept(String.format(TABS, item.getName(), item.getDecs(), item.getId()));
            }
            output.accept(END);
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
            output.accept(EDITION);
            String id = input.ask(INPUTID);
            Item old = tracker.findById(id);
            if (old == null) {
                output.accept(NOID);
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
                output.accept(String.format(DATA, id));
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
            output.accept(DELETION);
            String id = input.ask(INPUTID);
            if (tracker.delete(id)) {
                output.accept(DELETED);
            } else {
                output.accept(NOID);
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
            output.accept(FINDID);
            String id = input.ask(INPUTID);
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(DETAILS);
                output.accept(String.format(TABS, item.getName(), item.getDecs(), item.getId()));
            } else {
                output.accept(NOID);
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
            output.accept(FINDNAME);
            String name = input.ask(INPUTNAME.replace(BLANK, ""));
            List<Item> items = tracker.findByName(name);
            if (items.size() == 0) {
                output.accept(NONAME);
            } else {
                output.accept(DETAILS);
                for (Item item : items) {
                    output.accept(String.format(TABS, item.getName(), item.getDecs(), item.getId()));
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
            output.accept("Пока!");
        }
    }
}
