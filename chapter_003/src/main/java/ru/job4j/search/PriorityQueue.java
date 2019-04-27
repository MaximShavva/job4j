package ru.job4j.search;

import java.util.LinkedList;
import java.util.ListIterator;


/**
 * Класс представляет собой очередь с приоритетом.
 *
 * @author Шавва Максим.
 * @version 1.1
 * @since 27.04.2019г.
 */
public class PriorityQueue {
    /**
     * Список задач, расставленных по приоритету.
     */
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     *
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        for (var item : tasks) {
            if (task.getPriority() > item.getPriority()) {
                index++;
            }
        }
        tasks.add(index, task);
    }

    /**
     * Метод "снимает" задание с головы списка.
     *
     * @return Task
     */
    public Task take() {
        return this.tasks.poll();
    }

    public int getSize() {
        return tasks.size();
    }
}