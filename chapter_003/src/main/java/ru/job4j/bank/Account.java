package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс отвечает за хранение средств на конкретном банковском счете.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 17.04.2019г.
 */
public class Account {

    /**
     * Количество денег на счету.
     */
    private double values;

    /**
     * Реквизиты счёта.
     */
    private String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }

    public String getReqs() {
        return this.reqs;
    }

    public void setValues(double values) {
        this.values = values;
    }

    /**
     * Метод для перевода денег со счёта на счёт.
     *
     * @param destination счёт назначения.
     * @param amount      количество денег для перевода.
     * @return успех операции.
     */
    final boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values
                && destination != null
                && !destination.equals(this)) {
            this.values -= amount;
            destination.setValues(destination.getValues() + amount);
            success = true;
        }
        return success;
    }

    @Override
    public String toString() {
        return "Account{"
                + "values=" + values
                + ", reqs='" + reqs + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(reqs, account.reqs);
    }

    @Override
    public int hashCode() {
        return reqs.hashCode();
    }
}