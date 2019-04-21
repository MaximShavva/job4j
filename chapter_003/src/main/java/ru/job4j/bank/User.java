package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс отвечает за хранение данных о клиенте банка.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 17.04.2019г.
 */
public class User {

    /**
     * Имя клиента.
     */
    private String name;

    /**
     * Паспортные данные клиента.
     */
    private String passport;

    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", passport='" + passport + '\'' + '}';
    }
}