package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Calculate class Test.
 *
 * @author Максим Шавва (masyam@mail.ru)
 * @version 1
 * @since 0.1
 */
public class CalculateTest {
	/**
	* Тест метода echo.
	*/
	@Test //указывает, что этот метод нужно запустить через метод main. Делается это неявно
	public void whenTakeNameThenThreeEchoPlusName() {
		String input = "Maxim";
		String expect = "Echo, echo, echo : Maxim"; 
		Calculate calc = new Calculate();
		String result = calc.echo(input);
		assertThat(result, is(expect));
	}
}