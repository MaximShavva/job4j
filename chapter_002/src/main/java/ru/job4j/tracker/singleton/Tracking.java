package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;

import java.util.List;

/**
 * Устанавливает методы взаимодействия с "базой данных" заявок.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 02.04.2019г.
 */
public interface Tracking {
    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    Item add(Item item);

    /**
     * @param id какую заявку удалить.
     * @return если удаление успешно - true.
     */
    boolean delete(String id);

    /**
     * @param id   какому id присвоить новый item.
     * @param item заявка, которую сохраняем.
     * @return если замена произошла успешно, true.
     */
    boolean replace(String id, Item item);

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    List<Item> findByName(String key);

    /**
     * @param id передаём id  заявки, которую хотим получить.
     * @return получение заявки по id.
     */
    Item findById(String id);

    /**
     * @return получаем все заявки, которые есть на данный момент.
     */
    List<Item> findAll();
}