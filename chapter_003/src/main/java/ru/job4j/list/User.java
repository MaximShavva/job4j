package ru.job4j.list;

/**
 * Класс содержит поля пользователя User: id, name, city.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 13.04.2019г.
 */
public class User {
    /**
     * id пользователя.
     */
    private int id;

    /**
     * Имя пользователя.
     */
    private String name;

    /**
     * Город проживания пользователя.
     */
    private String city;

    public User(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    /**
     * Возвращает id пользователя.
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает имя пользователя.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает город проживания пользователя.
     */
    public String getCity() {
        return city;
    }
}