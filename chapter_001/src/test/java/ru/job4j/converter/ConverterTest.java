package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Converter class Test.
 *
 * @author Максим Шавва (masyam@mail.ru).
 * @version 1.
 * @since 18.03.2019г.
 */
public class ConverterTest {

    /**
     * Тест метода rubleToDollar.
     */
    @Test
    public void when60RubleToDollarThen1() {
        Converter toilet = new Converter();
        int result = toilet.rubleToDollar(60);
        assertThat(result, is(1));
    }

    /**
     * Тест метода rubleToEuro.
     */
    @Test
    public void when70RubleToEuroThen1() {
        Converter toilet = new Converter();
        int result = toilet.rubleToEuro(70);
        assertThat(result, is(1));
    }

    /**
     * Тест метода dollarToRuble.
     */
    @Test
    public void whenDollarToRublesThen60() {
        Converter toilet = new Converter();
        int result = toilet.dollarToRuble(1);
        assertThat(result, is(60));
    }

    /**
     * Тест метода euroToRuble.
     */
    @Test
    public void whenEuroToRublesThen70() {
        Converter toilet = new Converter();
        int result = toilet.euroToRuble(1);
        assertThat(result, is(70));
    }
}