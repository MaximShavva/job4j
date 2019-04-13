package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

/**
 * Класс - синглтон, декоратор для класса Tracker.
 * Тип - жадный синглтон на основе перечисления.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 13.04.2019г.
 */
public enum TrackerEagerEnum implements Tracking {
    /**
     * публичная константа хранит экземпляр TrackerEagerEnum
     */
    INSTANCE;
    /**
     * Композиция класса Tracker.
     */
    private static final Tracker TRACKER = new Tracker();

    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    public Item add(Item item) {
        return TRACKER.add(item);
    }

    /**
     * @param id какую заявку удалить.
     * @return если удаление успешно - true/
     */
    public boolean delete(String id) {
        return TRACKER.delete(id);
    }

    /**
     * @param id   какому id присвоить новый item.
     * @param item заявка, которую сохраняем.
     * @return если замена произошла успешно, true.
     */
    public boolean replace(String id, Item item) {
        return TRACKER.replace(id, item);
    }

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    public List<Item> findByName(String key) {
        return TRACKER.findByName(key);
    }

    /**
     * @param id передаём id  заявки, которую хотим получить.
     * @return получение заявки по id.
     */
    public Item findById(String id) {
        return TRACKER.findById(id);
    }

    /**
     * @return получаем все заявки, которые есть на данный момент.
     */
    public List<Item> findAll() {
        return TRACKER.findAll();
    }
}
