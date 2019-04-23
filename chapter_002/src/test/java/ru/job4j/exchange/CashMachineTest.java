package ru.job4j.exchange;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс CashMachine.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 23.04.2019г.
 */
public class CashMachineTest {

    /**
     * Тест метода exchange для неразменного случая.
     */
    @Test
    public void unchange() {
        CashMachine machine = new CashMachine(new int[]{1, 5, 10});
        List<List<Integer>> result = machine.exchange(1);
        assertThat(result, is(singletonList(singletonList(1))));
    }

    /**
     * Тест метода exchange для разменного случая сумма меньше,
     * чем наибольшая разменная монета.
     */
    @Test
    public void five() {
        CashMachine machine = new CashMachine(new int[]{1, 5, 10});
        List<List<Integer>> result = machine.exchange(5);
        assertThat(result, is(
                asList(
                        singletonList(5),
                        asList(1, 1, 1, 1, 1)
                )
        ));
    }

    /**
     * Тест метода exchange для разменного случая.
     * Сумма равна наибольшей разменной монете.
     */
    @Test
    public void change() {
        CashMachine machine = new CashMachine(new int[]{10, 5, 1});
        List<List<Integer>> result = machine.exchange(10);
        assertThat(
                result, is(
                        asList(
                                singletonList(10),
                                asList(5, 5),
                                asList(5, 1, 1, 1, 1, 1),
                                asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
                        )
                )
        );
    }

    /**
     * Тест метода exchange для разменного случая.
     * Сумма больше наибольшей разменной монеты.
     * В размен входят монеты, не кратные сумме для размена.
     */
    @Test
    public void whenNotRepeatedThen() {
        CashMachine machine = new CashMachine(new int[]{2, 5, 3});
        List<List<Integer>> result = machine.exchange(11);
        assertThat(
                result, is(
                        asList(
                                asList(5, 3, 3),
                                asList(5, 2, 2, 2),
                                asList(3, 3, 3, 2),
                                asList(3, 2, 2, 2, 2)
                        )
                )
        );
    }
}