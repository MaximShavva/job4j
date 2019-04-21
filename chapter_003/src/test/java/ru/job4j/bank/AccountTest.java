package ru.job4j.bank;

import javafx.beans.binding.When;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования класса Account.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 17.04.2019г.
 */
public class AccountTest {

    /**
     * HashCode.
     */
    @Test
    public void whenHashCodeThen() {
        Account a = new Account(655.11D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        Account c = new Account(317.80D, "6323 0010 7090 1000");
        assertThat(a.hashCode() == b.hashCode(), is(false));
        assertThat(c.hashCode() == b.hashCode(), is(true));
    }

    /**
     * Equals.
     */
    @Test
    public void whenEqualsThen() {
        Account a = new Account(655.11D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        Account c = new Account(317.80D, "6323 0010 7090 1000");
        assertThat(a.equals(b), is(false));
        assertThat(c.equals(b), is(true));
    }

    /**
     * Transfer, денег хватает.
     */
    @Test
    public void whenTransferOKThen() {
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        assertThat(a.transfer(b, 100.0D), is(true));
        assertThat(a.getValues(), is(217.80D));
        assertThat(b.getValues(), is(755.11D));
    }

    /**
     * Transfer, денег не хватает.
     */
    @Test
    public void whenTransferLowMoneyThen() {
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        assertThat(b.transfer(a, 700.0D), is(false));
        assertThat(a.getValues(), is(317.80D));
        assertThat(b.getValues(), is(655.11D));
    }

    /**
     * Transfer, некорректные данные:
     * (счёт == null,  перевод на этот же счёт, отрицательная сумма).
     */
    @Test
    public void whenTransferIncorrectDataThen() {
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        assertThat(b.transfer(a, -15.0D), is(false));
        assertThat(a.transfer(a, 15.0D), is(false));
        assertThat(a.transfer(null, 15.0D), is(false));
    }
}
