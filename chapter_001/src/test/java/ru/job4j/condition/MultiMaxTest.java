package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования MultiMax.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class MultiMaxTest {

    /**
     *Тестируем MultiMax.max().
     */
    @Test
    public void whenSecondMax() {
        MultiMax check = new MultiMax();
        int result = check.max(1, 4, 2);
        assertThat(result, is(4));
    }
}
