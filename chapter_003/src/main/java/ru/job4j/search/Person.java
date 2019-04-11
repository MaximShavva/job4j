package ru.job4j.search;

/**
 * Класс представляет собой абонента в телефонном справочнике.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 11.04.2019г.
 */
public class Person {
    /**
     * Имя абонента.
     */
    private String name;
    /**
     * Фамилия абонента.
     */
    private String surname;
    /**
     * Телефон абонента.
     */
    private String phone;
    /**
     * Адрес абонента.
     */
    private String address;

    public Person(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    /**
     * @return Имя абонента.
     */
    public String getName() {
        return name;
    }

    /**
     * @return Фамилия абонента.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @return Телефон абонента.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @return Адрес абонента.
     */
    public String getAddress() {
        return address;
    }
}