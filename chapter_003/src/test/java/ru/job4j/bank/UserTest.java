package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования класса User.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 17.04.2019г.
 */
public class UserTest {
    /**
     * Метод Hashcode.
     */
    @Test
    public void whenHashCodeThen() {
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        User eugen = new User("Michail", "997613");
        assertThat(eugen.hashCode() == misha.hashCode(), is(true));
        assertThat(eugen.hashCode() == vasya.hashCode(), is(false));
    }

    /**
     * Метод Equals.
     */
    @Test
    public void whenEqualsThen() {
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        User eugen = new User("Michail", "997613");
        assertThat(eugen.equals(misha), is(true));
        assertThat(eugen.equals(vasya), is(false));
    }
}