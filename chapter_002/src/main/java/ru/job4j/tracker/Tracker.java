package ru.job4j.tracker;

import ru.job4j.tracker.singleton.Tracking;

import java.util.Arrays;
import java.util.Random;

/**
 * Класс - хранилище заявок Item с реализацией CRUD
 * @author Шавва Максим.
 * @version 1.
 * @since 27.03.2019г.
 */
public class Tracker implements Tracking {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * @param item - заявка на добавление в массив
     * @return объект item cо своим id
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
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
            System.arraycopy(items, index + 1, items, index, --position - index);
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
            items[index] = item;
            result = true;
        }
        return result;
    }

    /**
     * @param key имя-ключ, по поторому делаем выборку заявок.
     * @return выборка заявок по имени.
     */
    public Item[] findByName(String key) {
        Item[] finded = new Item[position];
        int index = 0;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getName().equals(key)) {
                finded[index++] = items[i];
            }
        }
        return Arrays.copyOf(finded, index);
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
    public Item[] findAll() {
        return Arrays.copyOf(items, position);
    }

    /**
     * @param id определяет, какую позицию в списке вернуть.
     * @return позиция в списке.*/
    private int findPositionById(String id) {
        int result = -1;
        for (int i = 0; i != position; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
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