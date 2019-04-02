package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса StartUI.
 * На методы showAllBids(), findBidByID(), findBidByName()
 * тесты будут написаны в следующих упражнениях.
 *
 * @author Шавва Максим.
 * @version 2.
 * @since 30.03.2019г.
 */
public class StartUITest {
    /**
     * Поле содержит дефолтный вывод в консоль.
     */
    private final PrintStream stdout = System.out;
    /**
     * Поле содержит буфер для результата.
     */
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    /**
     * Строка - меню пользователя.
     */
    private final String menu = new StringBuilder()
            .append("0. Add new item.").append(System.lineSeparator())
            .append("1. Show all items.").append(System.lineSeparator())
            .append("2. Edit item.").append(System.lineSeparator())
            .append("3. Delete item.").append(System.lineSeparator())
            .append("4. Find item by Id.").append(System.lineSeparator())
            .append("5. Find items by name.").append(System.lineSeparator())
            .append("6. Exit Program.").append(System.lineSeparator())
            .toString();

    /**
     * Присваиваем переменной System.out поток ByteArray.
     */
    @Before
    public void loadOutput() {
        System.out.println("execute @Before");
        System.setOut(new PrintStream(this.out));
    }

    /**
     * Вернём переменной System.out поток по-умолчанию.
     */
    @After
    public void backOutput() {
        System.setOut(this.stdout);
        System.out.println("execute @After");
    }

    /**
     * Тест метода createBid().
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    /**
     * Тест метода showAllBids().
     * Проверяем в тесте вывод всех полей : name, description, ID
     */
    @Test
    public void whenShowAllSelectThenShowAllBids() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("test1", "test desc 1"));
        Item second = tracker.add(new Item("test2", "test desc 2"));
        Input input = new StubInput(new String[]{"1", "y"});
        new StartUI(input, tracker).init();
        String s = new String(out.toByteArray());
        assertThat(s.contains("test2")
                && s.contains("test desc 1")
                && s.contains(second.getId()), is(true));
    }

    /**
     * Тест метода editBid().
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест метода deleteBid().
     */
    @Test
    public void whenDeleteThenTrackerHasDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "test desc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(tracker.delete(item.getId()), is(false));
    }

    /**
     * Тест метода findBidByName().
     */
    @Test
    public void whenFindBidByNameSelectThenFindBidsByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Name", "desc1"));
        tracker.add(new Item("test1", "desc2"));
        tracker.add(new Item("Name", "desc3"));
        Input input = new StubInput(new String[]{"5", "Name", "y"});
        new StartUI(input, tracker).init();
        String s = new String(out.toByteArray());
        assertThat(s.contains("desc1")
                && s.contains("desc3")
                && !s.contains("desc2"), is(true));
    }

    /**
     * Тест метода findBidByID().
     */
    @Test
    public void whenFindBidByIDSelectThenFindBidByID() {
        Tracker tracker = new Tracker();
        Item second = tracker.add(new Item("test2", "test desc 2"));
        Input input = new StubInput(new String[]{"4", second.getId(), "y"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("------------ Поиск заявки по ID: --------------")
                        .append(System.lineSeparator())
                        .append("Заявка:         Описание:                ID:")
                        .append(System.lineSeparator())
                        .append("test2           test desc 2              ")
                        .append(second.getId()).append("   ")
                        .append(System.lineSeparator())
                        .toString()));

    }

    @Test
    public void whenExitThenPoka() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(new StringBuilder()
                        .append(menu)
                        .append("Пока!").append(System.lineSeparator())
                        .toString()));

    }
}