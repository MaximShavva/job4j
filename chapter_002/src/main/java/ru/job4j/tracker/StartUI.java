package ru.job4j.tracker;

/**
 * Класс должен обеспечить полноценную работу всего приложения (трекера).
 *
 * @author Шавва Максим.
 * @version 1
 * @since 28.03.2019г.
 */
public class StartUI {

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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createBid();
            } else if (ALL.equals(answer)) {
                this.showAllBids();
            } else if (EDIT.equals(answer)) {
                this.editBid();
            } else if (DEL.equals(answer)) {
                this.deleteBid();
            } else if (ID.equals(answer)) {
                this.findBidByID();
            } else if (NAME.equals(answer)) {
                this.findBidByName();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createBid() {
        System.out.println(ADDITION);
        String name = this.input.ask(INPUTNAME.replace(BLANK, ""));
        String desc = this.input.ask(DESK.replace(BLANK, ""));
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.printf(NEW, item.getId());
    }

    /**
     * Метод показывает все заявки на данный момент.
     */
    private void showAllBids() {
        System.out.println(BIDS);
        System.out.println(DETAILS);
        for (Item item : tracker.findAll()) {
            System.out.printf(TABS, item.getName(), item.getDecs(), item.getId());
        }
        System.out.println(END);
    }

    /**
     * Метод редактирует заявку.
     */
    private void editBid() {
        showAllBids();
        System.out.println(EDITION);
        String id = this.input.ask(INPUTID);
        Item old = tracker.findById(id);
        if (old == null) {
            System.out.println(NOID);
            return;
        }
        String name = this.input.ask(INPUTNAME);
        String desc = this.input.ask(DESK);
        if ("".equals(name)) name = old.getName();
        if ("".equals(desc)) desc = old.getDecs();
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.printf(DATA, id);
        }
    }

    /**
     * Метод удаляет заявку с указанным ID.
     */
    private void deleteBid() {
        showAllBids();
        System.out.println(DELETION);
        String id = this.input.ask(INPUTID);
        if (this.tracker.delete(id)) {
            System.out.println(DELETED);
        } else {
            System.out.println(NOID);
        }
    }

    /**
     * Метод находит заявку с указанным ID.
     */
    private void findBidByID() {
        System.out.println(FINDID);
        String id = this.input.ask(INPUTID);
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println(DETAILS);
            System.out.printf(TABS, item.getName(), item.getDecs(), item.getId());
        } else {
            System.out.println(NOID);
        }
    }

    /**
     * Метод находит все заявки с указанным именем.
     */
    private void findBidByName() {
        System.out.println(FINDNAME);
        String name = this.input.ask(INPUTNAME.replace(BLANK, ""));
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

    /**
     * Метод показвает меню трекера.
     */
    private void showMenu() {
        String[] list = {"Menu.", "0. Add new Bid", "1. Show all Bid", "2. Edit Bid", "3. Delete Bid",
                "4. Find Bid by Id", "5. Find Bids by name", "6. Exit Program"};
        for (String item : list) {
            System.out.println(item);
        }
    }

    /**
     * Запускт программы.
     * @param args параметры консоли.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}