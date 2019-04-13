package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

/**
 * Класс - синглтон, декоратор для класса Tracker.
 * Тип - ленивый синглтон на статическом классе.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 13.04.2019г.
 */
public class TrackerLazyClass implements Tracking {
    /**
     * Класс-холдер хранит синглтон и экземпляр Tracker.
     * Не создаётся, пока не будет вызван this.getInstance()
     */
    private static final class Holder {
        private static final TrackerLazyClass INSTANCE = new TrackerLazyClass();
        private static final Tracker tracker = new Tracker();
    }

    /**
     * Конструктор скрыт от пользователя класса.
     */
    private TrackerLazyClass() {}

    /**
     * @return Возвращает синглетон.
     */
    public static TrackerLazyClass getInstance() {
        return Holder.INSTANCE;
    }

    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    public Item add(Item item) {
        return Holder.tracker.add(item);
    }

    /**
     * @param id какую заявку удалить.
     * @return если удаление успешно - true/
     */
    public boolean delete(String id) {
        return Holder.tracker.delete(id);
    }

    /**
     * @param id   какому id присвоить новый item.
     * @param item заявка, которую сохраняем.
     * @return если замена произошла успешно, true.
     */
    public boolean replace(String id, Item item) {
        return Holder.tracker.replace(id, item);
    }

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    public List<Item> findByName(String key) {
        return Holder.tracker.findByName(key);
    }

    /**
     * @param id передаём id  заявки, которую хотим получить.
     * @return получение заявки по id.
     */
    public Item findById(String id) {
        return Holder.tracker.findById(id);
    }

    /**
     * @return получаем все заявки, которые есть на данный момент.
     */
    public List<Item> findAll() {
        return Holder.tracker.findAll();
    }
}
