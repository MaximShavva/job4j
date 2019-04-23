package ru.job4j.calculator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Calculator.
 */
public class CalculatorTest {
    /**
     * Здесь для примера заменили Реализацию BiFunction на сумму параметров.
     * А вывод на экран в Consumer заменили на добавление в список и
     * поэтому легко можем протестировать результат.
     */
    @Test
    public void whenAdd1Until3() {
        Calculator calc = new Calculator();
        List<Double> buffer = new ArrayList<>();
        calc.multiple(
                0, 3, 1,
                (value, index) -> (double) value + index,
                result -> buffer.add(result)
        );
        assertThat(buffer, is(Arrays.asList(1D, 2D, 3D)));
    }
}