package ru.job4j.search;

/**
 * Класс "Задание".
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 12.04.2019г.
 */
public class Task {
    /**
     * Описание задания.
     */
    private String desc;

    /**
     * Приоритет задания.
     */
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    /**
     * Возвращает Описание задания.
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Возвращает Приоритет задания.
     */
    public int getPriority() {
        return priority;
    }
}
