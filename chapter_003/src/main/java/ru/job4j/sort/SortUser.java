package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * Класс содержит метод, возвращающий set пользователей,
 * отсортированных по возрасту в порядке возрастания.
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
    public Set<User> sort (List<User> list) {
        return new TreeSet<>(list);
    }
}