package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Класс - хранилище заявок Item с реализацией CRUD
 * @author Шавва Максим.
 * @version 1.1
 * @since 13.04.2019г.
 */
public class Tracker implements Tracking {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * @param id какую заявку удалить.
     * @return если удаление успешно - true/
     */
    public boolean delete(String id) {
        boolean result = false;
        int index = findPositionById(id);
        if (index != -1) {
            items.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * @param id какому id присвоить новый item.
     * @param item заявка, которую сохраняем.
     * @return если замена произошла успешно, true.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        int index = findPositionById(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            result = true;
        }
        return result;
    }

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    public List<Item> findByName(String key) {
        List<Item> finded = new ArrayList<>();
        for (Item item :items) {
            if (key.equals(item.getName())) {
                finded.add(item);
            }
        }
        return finded;
    }

    /**
     * @param id передаём id  заявки, которую хотим получить.
     * @return получение заявки по id.
     * */
    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * @return получаем все заявки, которые есть на данный момент.
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * @param id определяет, какую позицию в списке вернуть.
     * @return позиция в списке.*/
    private int findPositionById(String id) {
        int result = -1;
        for (int i = 0; i != items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

    /**
     * @return генерируем id на основе системного времени и рандома.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}