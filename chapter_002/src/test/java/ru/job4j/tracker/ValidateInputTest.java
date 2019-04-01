package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Тест класса ValidateInput.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 01.04.2019г.
 */
public class ValidateInputTest {
    /**
     * Поток записи в ByteArray
     */
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();

    /**
     * Сохраняем сюда значение переменной System.out.
     */
    private final PrintStream out = System.out;

    /**
     * Подменяем Sysyem.out байтовым потоком
     */
    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    /**
     * Возвращаем Sysyem.out стандартный поток вывода в консоль
     */
    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * Тест метода ask, когда пользователь "ввёл" не числовое значение.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"invalid", "1"}));
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Не корректный номер. Попробуй ещё раз.%n")
                )
        );
    }

    /**
     * Тест метода ask, когда пользователь "ввёл" неправильный пункт меню.
     */
    @Test
    public void whenOutOfMenuInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"2", "1"}));
        input.ask("Enter", new int[]{1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Ты ввел(а) неправильный пункт меню!%n")
                )
        );
    }

}