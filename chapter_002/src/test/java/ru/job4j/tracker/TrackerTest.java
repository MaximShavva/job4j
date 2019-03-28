package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Tracker.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 27.03.2019г.
 */
public class TrackerTest {

    /**
     * Тест Tracker.add()
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Tracker.findById()
     */
    @Test
    public void whenFindByIdThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1", "testDescription", created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест Tracker.replace()
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", 1234L);
        next.setId(previous.getId());
        assertThat(tracker.replace(previous.getId(), next), is(true));
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест Tracker.delete()
     */
    @Test
    public void whenDeleteItemThenReturnTrue() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        Item next = new Item("test2", "testDescription2", 1234L);
        tracker.add(previous);
        tracker.add(next);
        String id = previous.getId();
        assertThat(tracker.delete(id), is(true));
        assertThat(tracker.delete(id), is(false));
    }

    /**
     * Тест Tracker.findByName()
     */
    @Test
    public void whenFindByNameThenReturnItems() {
        Tracker tracker = new Tracker();
        String name = "test3";
        Item previous = new Item(name, "testDescription", 123L);
        Item next = new Item(name, "testDescription2", 1234L);
        tracker.add(previous);
        tracker.add(next);
        assertThat(tracker.findByName(name), is(new Item[]{previous, next}));
    }

    /**
     * Тест Tracker.findAll()
     */
    @Test
    public void whenFindAllThenReturnAllItems() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test4", "testDescription", 123L);
        Item next = new Item("test4", "testDescription2", 1234L);
        tracker.add(previous);
        tracker.add(next);
        assertThat(tracker.findAll(), is(new Item[]{previous, next}));
    }
}