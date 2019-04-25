package ru.job4j.address;

/**
 * Класс содержит данные о клиенте.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class Profile {

    /**
     * Имя клиента.
     */
    private String name;

    /**
     * Адрес клиента.
     */
    private Address address;

    public Profile(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
