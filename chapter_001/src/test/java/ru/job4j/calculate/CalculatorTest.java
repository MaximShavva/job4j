package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculator class Test.
 *
 * @author Максим Шавва (masyam@mail.ru)
 * @version 1
 * @since 18.03.2019г.
 */
public class CalculatorTest {
	/**
	* Тест метода add.
	*/
	@Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        double result = calc.add(1D, 1D);
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода div.
     */
    @Test
    public void whenDiv2On2Then1() {
        Calculator calc = new Calculator();
        double result = calc.div(2D, 2D);
        double expected = 1D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода multiple.
     */
    @Test
    public void whenMultiple2On2Then4() {
        Calculator calc = new Calculator();
        double result = calc.multiple(2D, 2D);
        double expected = 4D;
        assertThat(result, is(expected));
    }

    /**
     * Тест метода subtract.
     */
    @Test
    public void whenSubtract1from2Then1() {
        Calculator calc = new Calculator();
        double result = calc.subtract(2D, 1D);
        double expected = 1D;
        assertThat(result, is(expected));
    }
}