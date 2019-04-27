package ru.job4j.search;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Класс представляет собой модель телефонного справочника
 * с возможностью добавления новых абонентов и их поиска.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 11.04.2019г.
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    /**
     * Добавляем новых абонентов в справочник.
     *
     * @param person Добавляемый абонент.
     */
    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     *
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        var result = new ArrayList<Person>();
        var iter = persons.iterator();
        iter.forEachRemaining(person -> {
            if (person.getName().contains(key)
                    || person.getSurname().contains(key)
                    || person.getPhone().contains(key)
                    || person.getAddress().contains(key)
            ) {
                result.add(person);
            }
        });
        return result;
    }
}