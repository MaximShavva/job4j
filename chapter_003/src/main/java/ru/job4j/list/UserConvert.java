package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

/**
 * Класс содержит метод по преобразованию списка List<User>
 * в Map<Integer, User>.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 13.04.2019г.
 */
public class UserConvert {
    /**
     * @param list Список
     * @return Мапа
     */
    HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> map = new HashMap<>();
        list.forEach(user -> map.put(user.getId(), user));
        return map;
    }
}