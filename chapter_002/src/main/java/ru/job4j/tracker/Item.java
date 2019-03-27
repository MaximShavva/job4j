package ru.job4j.tracker;

import java.util.Objects;

/**
 * Класс - заявка Item, содержит геттеры, сеттеры полей,
 * метод сравнения 2 заявок и метод вычисления хэшкода.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 27.03.2019г.
 */
public class Item {
    /**
     * Идентификатор заявки.
     */
    private String id;
    /**
     * Название заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String decs;
    /**
     * Время создания заявки.
     */
    private long time;

    public Item(String name, String decs, long time) {
        this.name = name;
        this.decs = decs;
        this.time = time;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDecs(String decs) {
        this.decs = decs;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDecs() {
        return decs;
    }

    public long getTime() {
        return time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return time == item.time &&
                Objects.equals(id, item.id) &&
                Objects.equals(name, item.name) &&
                Objects.equals(decs, item.decs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, decs, time);
    }
}