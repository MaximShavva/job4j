package ru.job4j.search;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Task task = (Task) o;
        return priority == task.priority
                && Objects.equals(desc, task.desc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desc, priority);
    }

    @Override
    public String toString() {
        return "Task{"
                + "desc='" + desc + '\''
                + ", priority=" + priority + '}';
    }
}