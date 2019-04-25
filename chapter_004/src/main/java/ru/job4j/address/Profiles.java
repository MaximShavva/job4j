package ru.job4j.address;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс содержит метод collect() для выборки адресов из списка порфилей.
 * Так же метод убирает одинаковые адреса и сортирует адреса по городам.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class Profiles {

    /**
     * @param profiles Список всех профилей клиентов.
     * @return Список адресов клиентов.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}