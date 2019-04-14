package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

/**
 * Класс - синглтон, декоратор для класса Tracker.
 * Тип - ленивый синглтон на статическом поле.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 13.04.2019г.
 */
public class TrackerLazyField implements Tracking {

    /**
     * Хранит экземпляр - синглтон TrackerLazyField.
     */
    private static TrackerLazyField instance;

    /**
     * Композиция класса Tracker.
     */
    private static Tracker tracker;

    /**
     * Конструктор скрыт от пользователя класса.
     */
    private TrackerLazyField() {
    }

    /**
     * @return Возвращает синглетон.
     */
    public static TrackerLazyField getInstance() {
        if (instance == null) {
            instance = new TrackerLazyField();
            tracker = new Tracker();
        }
        return instance;
    }

    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    public Item add(Item item) {
        return tracker.add(item);
    }

    /**
     * @param id какую заявку удалить.
     * @return если удаление успешно - true/
     */
    public boolean delete(String id) {
        return tracker.delete(id);
    }

    /**
     * @param id   какому id присвоить новый item.
     * @param item заявка, которую сохраняем.
     * @return если замена произошла успешно, true.
     */
    public boolean replace(String id, Item item) {
        return tracker.replace(id, item);
    }

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    /**
     * @param id передаём id  заявки, которую хотим получить.
     * @return получение заявки по id.
     */
    public Item findById(String id) {
        return tracker.findById(id);
    }

    /**
     * @return получаем все заявки, которые есть на данный момент.
     */
    public List<Item> findAll() {
        return tracker.findAll();
    }
}
