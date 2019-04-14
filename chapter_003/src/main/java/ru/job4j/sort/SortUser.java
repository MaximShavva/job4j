package ru.job4j.sort;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Класс содержит методы сортировки, по длине имени,
 * по возрасту, по имени и возрасту.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 14.04.2019г.
 */
public class SortUser {

    /**
     * @param list Список пользователей.
     * @return set отсортированных пользователей.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }

    /**
     * Определяем свой компаратор для сортировки по длине имени.
     *
     * @param list список для сортировки.
     * @return отсортированный список.
     */
    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o1.getName().length(), o2.getName().length());
            }
        });
        return list;
    }

    /**
     * Oпределить Comparator и отсортировать List<User> по обоим полям,
     * сначала сортировка по имени в лексикографическом порядке, потом по возрасту.
     *
     * @param list список для сортировки.
     * @return отсортированный список.
     */
    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().compareTo(o2.getName());
            }
        }.thenComparing(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        }));
        return list;
    }
}