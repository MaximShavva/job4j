package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования Counter.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 19.03.2019г.
 */
public class CounterTest {

    /**
     * Тестируем Counter.add() от 1 до 10.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        Counter counter = new Counter();
        int sum = counter.add(1, 10);
        assertThat(sum, is(30));
    }

    /**
     * Тестируем Counter.add() от 10 до 1.
     */
    @Test
    public void whenSumEvenNumbersFromTenToOneThenThirty() {
        //напишите здесь тест, проверяющий, что сумма чётных чисел от 1 до 10 при вызове метода counter.add будет равна 30.
        Counter counter = new Counter();
        int sum = counter.add(10, 1);
        assertThat(sum, is(30));
    }
}
