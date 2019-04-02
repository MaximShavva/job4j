package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест классов - синглтонов из пакета singleton на предмет их
 * создания в единственном экземпляре.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 02.04.2019г.
 */
public class SingletonTest {
    /**
     * Тест ленивого синглтона на статическом поле.
     */
    @Test
    public void whenLazyFieldInstancesThenHasOne() {
        TrackerLazyField first = TrackerLazyField.getInstance();
        TrackerLazyField second = TrackerLazyField.getInstance();
        assertThat(first == second, is(true));
    }

    /**
     * Тест жадного синглтона на статическом поле.
     */
    @Test
    public void whenEagerFieldInstancesThenHasOne() {
        TrackerEagerField first = TrackerEagerField.getInstance();
        TrackerEagerField second = TrackerEagerField.getInstance();
        assertThat(first == second, is(true));
    }

    /**
     * Тест ленивого синглтона на статическом классе.
     */
    @Test
    public void whenLazyClassInstancesThenHasOne() {
        TrackerLazyClass first = TrackerLazyClass.getInstance();
        TrackerLazyClass second = TrackerLazyClass.getInstance();
        assertThat(first == second, is(true));
    }

    /**
     * Тест жадного синглтона на перечислении.
     */
    @Test
    public void whenEagerEnumInstancesThenHasOne() {
        TrackerEagerEnum first = TrackerEagerEnum.INSTANCE;
        TrackerEagerEnum second = TrackerEagerEnum.INSTANCE;
        assertThat(first == second, is(true));
    }
}