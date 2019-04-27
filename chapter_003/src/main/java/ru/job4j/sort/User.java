package ru.job4j.sort;

import java.util.Objects;

/**
 * Класс содержит поля пользователя User: name, age.
 * Переопределён метод compareTo для сортировки по возрасту.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 14.04.2019г.
 */
public class User implements Comparable<User> {
    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Возраст пользователя.
     */
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Возвращает имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает возраст пользователя.
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param o объект для сравнения.
     * @return результат сравнения.
     */
    @Override
    public int compareTo(User o) {
        return this.age.compareTo(o.getAge());
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
        return Objects.equals(name, user.name)
                && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", age=" + age + '}';
    }
}