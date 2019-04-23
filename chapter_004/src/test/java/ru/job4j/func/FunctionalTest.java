package ru.job4j.func;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.closeTo;

/**
 * Класс для тестирования Functional.diapason().
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 24.04.2019г.
 */
public class FunctionalTest {

    /**
     * Тестируем метод Functional.diapason() с лямбда - выражением
     * линейной функции.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тестируем метод Functional.diapason() с лямбда - выражением
     * квадратичной функции.
     */
    @Test
    public void whenSquareFunctionThenSquareResults() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, x -> x * (x - 5));
        List<Double> expected = Arrays.asList(0D, 6D, 14D);
        assertThat(result, is(expected));
    }

    /**
     * Тестируем метод Functional.diapason() с лямбда - выражением
     * логарифмической функции.
     */
    @Test
    public void whenLogarithmicFunctionThenLogarithmicResults() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, x -> Math.log10(x) + Math.log(x));
        List<Double> expected = Arrays.asList(2.31, 2.57, 2.79);
        for (int i = 0; i != result.size(); i++) {
            assertThat(result.get(i), closeTo(expected.get(i), 0.01));
        }
    }

    /**
     * Тестируем метод Functional.diapason() со ссылкой на метод FunctionSet.liner()
     */
    @Test
    public void whenLinearFunctionLinkThen() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, Functional.FunctionSet::liner);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тестируем метод Functional.diapason() со ссылкой на метод FunctionSet.square()
     */
    @Test
    public void whenSquareFunctionLinkThen() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, Functional.FunctionSet::square);
        List<Double> expected = Arrays.asList(0D, 6D, 14D);
        assertThat(result, is(expected));
    }

    /**
     * Тестируем метод Functional.diapason() со ссылкой на метод FunctionSet.logarithmic()
     */
    @Test
    public void whenLogarithmicFunctionLinkThen() {
        Functional function = new Functional();
        List<Double> result = function.diapason(5, 8, Functional.FunctionSet::logarithmic);
        List<Double> expected = Arrays.asList(2.31, 2.57, 2.79);
        for (int i = 0; i != result.size(); i++) {
            assertThat(result.get(i), closeTo(expected.get(i), 0.01));
        }
    }
}