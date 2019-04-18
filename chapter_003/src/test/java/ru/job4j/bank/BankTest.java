package ru.job4j.bank;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Класс для тестирования класса Bank.
 *
 * @author Шавва Максим.
 * @version 1.2
 * @since 21.04.2019г.
 */
public class BankTest {

    /**
     * Метод addUser добавляет, но не "затирает" пользователя, если таковой уже есть.
     */
    @Test
    public void whenAddSameUserThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        bank.addUser(vasya);
        bank.addAccountToUser(vasya, a);
        bank.addUser(vasya);
        assertThat(bank.toString(), is("Bank{accounts={"
                + "User{name='Vasily', passport='147918'}=["
                + "Account{values=317.8, reqs='2333 4800 3456 2848'}]}}"));
    }

    /**
     * Метод deleteUser удаляет пользователя. Не падает, если пользователя нет
     * в списке.
     */
    @Test
    public void whenDeleteUserThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        bank.addUser(vasya);
        bank.addUser(misha);
        bank.deleteUser(vasya);
        bank.deleteUser(vasya);
        assertThat(bank.toString(), is("Bank{accounts={"
                + "User{name='Michail', passport='997613'}=[]}}"));
    }

    /**
     * Метод addAccountToUser не должен добавлять аккаунт, если есть в списке.
     */
    @Test
    public void whenAddAccountToUserThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        Account c = new Account(317.80D, "6323 0010 7090 1000");
        bank.addUser(vasya);
        bank.addAccountToUser(vasya, b);
        bank.addAccountToUser(vasya, b);
        bank.addAccountToUser(misha, c);
        assertThat(bank.toString(), is("Bank{accounts={"
                + "User{name='Vasily', passport='147918'}=["
                + "Account{values=655.11, reqs='6323 0010 7090 1000'}]}}"));
    }

    /**
     * Метод deleteAccountFromUser.
     */
    @Test
    public void whenDeleteAccountFromUserThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        bank.addUser(vasya);
        bank.addAccountToUser(vasya, a);
        bank.addAccountToUser(vasya, b);
        bank.deleteAccountFromUser(vasya, a);
        bank.deleteAccountFromUser(vasya, a);
        bank.deleteAccountFromUser(misha, b);
        assertThat(bank.toString(), is("Bank{accounts={"
                + "User{name='Vasily', passport='147918'}=["
                + "Account{values=655.11, reqs='6323 0010 7090 1000'}]}}"));
    }

    /**
     * Метод getAccounts.
     */
    @Test
    public void whenGetActualAccountThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        bank.addUser(vasya);
        bank.addAccountToUser(vasya, a);
        bank.addAccountToUser(vasya, b);
        assertThat(bank.getAccounts(vasya).toString(), is(
                "[Account{values=317.8, reqs='2333 4800 3456 2848'}, "
                        + "Account{values=655.11, reqs='6323 0010 7090 1000'}]"));
    }

    /**
     * Метод transferMoney between Users.
     */
    @Test
    public void whenTransferMoney2UsersThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        User misha = new User("Michail", "997613");
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        bank.addUser(vasya);
        bank.addUser(misha);
        bank.addAccountToUser(vasya, a);
        bank.addAccountToUser(misha, b);
        assertThat(bank.transferMoney(
                "997613",
                "6323 0010 7090 1000",
                "147918",
                "2333 4800 3456 2848",
                300), is(true));
        assertThat(bank.transferMoney(
                "997613",
                "6323 0010 7090 1000",
                "147918",
                "2333 4800 3456 2848",
                700), is(false));
    }

    /**
     * Метод transferMoney within User.
     */
    @Test
    public void whenTransferMoney1UserThen() {
        Bank bank = new Bank();
        User vasya = new User("Vasily", "147918");
        Account a = new Account(317.80D, "2333 4800 3456 2848");
        Account b = new Account(655.11D, "6323 0010 7090 1000");
        bank.addUser(vasya);
        bank.addAccountToUser(vasya, a);
        bank.addAccountToUser(vasya, b);
        assertThat(bank.transferMoney(
                "147918",
                "2333 4800 3456 2848",
                "147918",
                "6323 0010 7090 1000",
                300), is(true));
        assertThat(bank.transferMoney(
                "147918",
                "2333 4800 3456 2848",
                "147918",
                "6323 0010 7090 1000",
                700), is(false));
    }
}